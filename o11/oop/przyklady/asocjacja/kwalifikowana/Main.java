package basics.o11.oop.przyklady.asocjacja.kwalifikowana;

public class Main {
    public static void main(String[] args) {

                /*
        W Javie asocjacja z kwalifikatorem to szczególny rodzaj asocjacji pomiędzy klasami, w której dodatkowo występuje tzw. kwalifikator.
        Kwalifikator to atrybut (pole), który umożliwia zidentyfikowanie konkretnego obiektu w asocjacji, często w kontekście mapowania (np. w kolekcjach takich jak Map).

        Asocjacja z kwalifikatorem jest najczęściej używana w sytuacjach, gdy obiekty w relacji są unikalnie identyfikowane
        za pomocą jakiegoś klucza. Można to rozumieć jako odwzorowanie na Map<Key, Value> w programowaniu.
         */

        Library lib = new Library();

        Book ks1 = new Book("978-1234567890", "Władca Pierścieni");
        Book ks2 = new Book("978-0987654321", "Harry Potter");

        lib.addBook(ks1);
        lib.addBook(ks2);

        System.out.println(lib.findBookByIsbn("978-1234567890")); // Władca Pierścieni

        /*
        Kwalifikator:
              - Może być dowolnym unikalnym atrybutem (np. identyfikator, kod, nazwa).
              - Działa jako klucz do odwzorowania asocjacji.
        Użycie:
              - Realizowane najczęściej za pomocą kolekcji Map w Javie.
              - Zalety:
              - Zwiększa wydajność wyszukiwania obiektów w relacji.
              - Ułatwia zarządzanie powiązaniami, gdy potrzebujemy jednoznacznego identyfikatora.
         */

    }
}
