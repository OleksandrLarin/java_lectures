package lecture15.generic;

import java.util.ArrayList;
import java.util.List;

public class Storage<T> {
    private List<T> books = new ArrayList<>();

    public void addAll(List<T> list) {
        books.addAll(list);
    }

    public static void main(String[] args) {
        Storage<Book> storage = new Storage<>();
        List<? super Book> albums = new ArrayList<>();
//        storage.addAll(albums);
    }
}
