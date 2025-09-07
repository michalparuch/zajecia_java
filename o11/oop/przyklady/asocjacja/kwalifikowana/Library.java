package basics.o11.oop.przyklady.asocjacja.kwalifikowana;

import java.util.HashMap;
import java.util.Map;

public class Library {

    // Mapa ISBN -> Ksiazka
    private Map<String, Book> katalog = new HashMap<>();

    public void addBook(Book book) {
        katalog.put(book.getIsbn(), book);
    }

    public Book findBookByIsbn(String isbn) {
        return katalog.get(isbn);
    }

}
