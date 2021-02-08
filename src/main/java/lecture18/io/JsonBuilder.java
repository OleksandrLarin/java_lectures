package lecture18.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class JsonBuilder {

    private static final String END = "end";
    private static final String KEY_VALUE = "\"%s\":\"%s\"";
    private static final String KEY_VALUE_INTEGER = "\"%s\":%d";
    private static final String DELIMITER = "=";
    public static final String COMMA = ",";

    public static void main(String[] args) {
        JsonBuilder jsonBuilder = new JsonBuilder();
        File jsonFile = new File("src//main//resources//output.json");

        Map<String, String> map = jsonBuilder.readFromConsole();

        jsonBuilder.createJsonFile(jsonFile, map);
    }

    private Map<String, String> readFromConsole() {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> map = new TreeMap<>();
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if (input.equals(END) || input.equals("")) {
                break;
            }
            String[] pair = input.split(DELIMITER);
            map.put(pair[0].trim(), pair[1].trim());
        }
        return map;
    }

    private void createJsonFile(File file, Map<String, String> map) {
        try (FileWriter writer = new FileWriter(file)) {
            startWrite(writer);
            writeContent(map, writer);
            endWrite(writer);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void writeContent(Map<String, String> map, FileWriter writer) throws IOException {
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        String stringBuilder = getString(iterator);
        writer.write(stringBuilder);
    }

    private String getString(Iterator<Map.Entry<String, String>> iterator) {
        StringBuilder stringBuilder = new StringBuilder();
        while (iterator.hasNext()) {
            stringBuilder.append(formatString(iterator.next()));
            stringBuilder.append(COMMA);
        }
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(COMMA));
        return stringBuilder.toString();
    }

    private String formatString(Map.Entry<String, String> entry) {
        if (ifInteger(entry.getValue())){
            Integer value = Integer.valueOf(entry.getValue());
            return String.format(KEY_VALUE_INTEGER, entry.getKey(), value);
        }
        return String.format(KEY_VALUE, entry.getKey(), entry.getValue());
    }

    private boolean ifInteger(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private void startWrite(FileWriter writer) throws IOException {
        writer.write("{");
    }

    private void endWrite(FileWriter writer) throws IOException {
        writer.write("}");
    }
}
