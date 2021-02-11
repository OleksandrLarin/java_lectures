package lecture19.io;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

//Ввести с консоли имя файла
//Считать все байты из файла.
//Не учитывая повторений - отсортировать их по байт-коду в убывающем порядке.
//Вывести на экран
//Закрыть поток ввода-вывода
public class ByteReader {
    private String fileName;

    public ByteReader(String fileName) {
        this.fileName = fileName;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        ByteReader byteReader = new ByteReader(fileName);

        Set<Integer> byteSet = byteReader.readBytes();
        System.out.println(byteSet);
    }

    private Set<Integer> readBytes() {
        Set<Integer> set = new TreeSet<>(Comparator.reverseOrder());
        try (FileInputStream inputStream = new FileInputStream(fileName)) {
            int b;
            while ((b = inputStream.read()) != -1) {
                set.add(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return set;
    }
}
