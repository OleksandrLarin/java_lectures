package lecture18.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamExample {
    public static void main(String[] args) {
        String fileName = "src/main/resources/input.md";
        File file = new File(fileName);

        try (FileInputStream inputStream = new FileInputStream(file)) {
            int symbol;
            while ((symbol = inputStream.read()) != -1) {
                System.out.print((char) symbol);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
