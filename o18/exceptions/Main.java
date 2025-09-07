package basics.o18.exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        // Hierarchia klas wyjątków w Javie:
        // Po klasie Throwable dziedziczą dwie klasy: Exception oraz Error.
        // - Error: sygnalizuje błędy krytyczne, które są rzucane przez JVM i nie powinny być obsługiwane przez aplikację.
        //   Są to na przykład: OutOfMemoryError, StackOverflowError.
        // - Exception: oznacza problemy, które aplikacja może i powinna obsłużyć, np. IOException, SQLException.
        //
        // Przykładowa hierarchia:
        // IllegalArgumentException -> RuntimeException -> Exception -> Throwable

        /*
         * RuntimeException vs Exception:
         * - RuntimeException: wyjątki niesprawdzane (unchecked exceptions), wynikające najczęściej z błędów programistycznych.
         *   Nie muszą być deklarowane ani obsługiwane w kodzie (np. NullPointerException, ArrayIndexOutOfBoundsException).
         * - Exception: wyjątki sprawdzane (checked exceptions), które muszą być obsłużone lub deklarowane w sygnaturze metody
         *   (np. IOException, SQLException).
         */

        /*
        Jeśli chcesz, aby Twój wyjątek był checked exception, powinien dziedziczyć po klasie Exception (ale nie po RuntimeException).
        Kiedy stosować?
        Gdy oczekujesz, że użytkownik Twojej klasy/biblioteki będzie musiał jawnie obsłużyć ten wyjątek.
        Wyjątek dotyczy sytuacji zewnętrznej (np. problemów z plikami, bazami danych, siecią).

        Jeśli chcesz, aby Twój wyjątek był unchecked exception, powinien dziedziczyć po klasie RuntimeException.
        Kiedy stosować?
        Gdy wyjątek dotyczy błędu programistycznego lub wewnętrznej logiki programu.
        Gdy użytkownik Twojej klasy/biblioteki nie powinien być zmuszony do obsługi wyjątku (może, ale nie musi tego robić).
         */

        // Przykłady popularnych wyjątków:
        // - NullPointerException: rzucany, gdy próbujesz wywołać metodę na zmiennej o wartości null.
        // - IllegalArgumentException: rzucany, gdy argument metody jest nieprawidłowy.
        // - IOException: związany z błędami wejścia/wyjścia (np. problem z plikiem).
        // - NumberFormatException: rzucany, gdy próba parsowania Stringa na liczbę nie powiedzie się (np. String zawiera litery).
        // - IndexOutOfBoundsException: występuje, gdy próbujesz uzyskać dostęp do indeksu poza zakresem tablicy lub listy.


        // Przykład obsługi checked exception (IOException):
//        readFile("example.txt");

        try {
            readFile("example.txt");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }


        // Unchecked exceptions (nie sprawdzane wyjątki): wynikają głównie z błędów programistycznych,
        // nie muszą być obsługiwane (NullPointerException, ArrayIndexOutOfBoundsException).

        // Przykład obsługi unchecked exception (ArrayIndexOutOfBoundsException):

//        accessArray();
        try {
            accessArray();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: You are trying to access an invalid array index.");
        }

        // Obsługa wyjątków z blokiem finally:

        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[0]); // Spowoduje ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error 2: You are trying to access an invalid array index.");
        } finally {
            System.out.println("This block is always executed.");
        }

        // Creating a custom exception
//        myMethod();

        // Przykład stworzenia własnego wyjątku:

//        try {
//            int a = 5 / 0;
//        } catch (Throwable e) {
//            throw new MyUncheckedException(e);  // Rzucenie własnego wyjątku
//        }


        // try-with-resources
        // W Javie konstrukcja try-with-resources została wprowadzona w Java 7 i pozwala na automatyczne
        // zamykanie zasobów, takich jak pliki, strumienie wejścia/wyjścia czy połączenia z bazą danych.
        // Główną zaletą jest to, że zasoby są automatycznie zamykane, nawet jeśli wystąpi wyjątek w bloku try.

        String filePath = "example.txt";
        // Try-with-resources otwiera i automatycznie zamyka zasób
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }

        // W sekcji try deklarujesz zasoby, które implementują interfejs AutoCloseable (np. BufferedReader, FileReader, Scanner).
        // Po zakończeniu bloku try zasoby są automatycznie zamykane metodą close(), niezależnie od tego, czy wyjątek wystąpił, czy nie.

        // Każdy zasób używany w konstrukcji try-with-resources musi implementować interfejs AutoCloseable.

        try (MyResource resource = new MyResource()) {
            resource.doSomething();
        } catch (Exception e) {
            System.out.println("An exception occurred: " + e.getMessage());
        }

    }

    // Metoda rzucająca checked exception (IOException):

    public static void readFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }

    // Metoda generująca ArrayIndexOutOfBoundsException:

    public static void accessArray() {
        int[] numbers = {1, 2, 3};
        System.out.println(numbers[10]);  // Spowoduje ArrayIndexOutOfBoundsException
    }

    // Przykład własnej klasy wyjątku:

    public static void myMethod() {
        throw new MyUncheckedException("This is a custom unchecked exception");
    }

}
