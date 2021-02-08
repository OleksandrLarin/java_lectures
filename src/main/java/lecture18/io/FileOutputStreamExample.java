package lecture18.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamExample {
    public static void main(String[] args) {
        String fileName = "src/main/resources/otuput.txt";
        String outputText = "Test Text";

        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName, true)) {
            fileOutputStream.write(outputText.getBytes());
        } catch (FileNotFoundException e) {
            System.out.println("File " + fileName + " is not found");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
