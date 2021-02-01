package lecture15.generic;


import java.util.ArrayList;
import java.util.List;

public class BookService {

    public static void main(String[] args) {
        List<Album> albumSource = new ArrayList<>();
        List<Album> albumDestination = new ArrayList<>();
        List<Book> booksDestination = new ArrayList<>();
        copyToBooks(albumSource, booksDestination);
        copyToBooks(albumSource, albumDestination);
    }


    public static <T extends Book> void copyToBooks(List<? extends T> src, List<? super T> dest) {
        for (T book : src) {
            dest.add(book);
        }
    }
}
