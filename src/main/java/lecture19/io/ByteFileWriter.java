package lecture19.io;

import java.io.FileOutputStream;
import java.io.IOException;

public class ByteFileWriter {
    public static void main(String[] args) {
        try (FileOutputStream outputStream = new FileOutputStream("test.dat")){
            outputStream.write(44);
            outputStream.write(56);
            outputStream.write(44);
            outputStream.write(4);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
