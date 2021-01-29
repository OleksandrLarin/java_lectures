package lecture15.generic;

import java.util.ArrayList;
import java.util.List;

public class UpperWildcards {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        List<Album> albums = new ArrayList<>();
        books.add(new Book());
        books.add(new Album());
//        List<Brochure> brochures = new ArrayList<>();
//        List<Booklet> booklets = new ArrayList<>();


        print(books);
        print(albums);
//        print(brochures);
//        print(booklets);
    }


    private static void print(List<? extends Book> items) {
        Book book = items.get(0);
//        items.add(book);
        for (Book b : items) {
            System.out.println(b.toString());
        }
    }
}
