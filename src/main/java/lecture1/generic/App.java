package lecture1.generic;

public class App {
    public static void main(String[] args) {
        String[] strings = {"A1", "B2"};
        printArray(strings);
    }

    public static <T> void printArray(T[] array) {
        for (T item : array) {
            System.out.println(item);
        }
    }
}
