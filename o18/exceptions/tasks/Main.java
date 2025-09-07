package basics.o18.exceptions.tasks;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {


        //Stworz program ktory pozwoli odczytac z pliku zawarte informacje.
        //Jesli plik nie istnieje to obsluz ta sytuacje i stworz go (createNewFile() z instancji klasy File stworz nowy plik)

        ReadFile readFile = new ReadFile();

        readFile.tryReadFile("test.txt");

        //1
        // Stwórz liste i dodaj jej 3 eleemtny np Stringi. Losujemy liczbe z zakrezu 0-5
        // i do zmiennej typu String
        // przypisujemy wylosowany element listy, obsluz sytuacje gdy wylosowana wartosc
        // jest poza zakresem listy
        RandomListElement randomListElement = new RandomListElement();
        randomListElement.readElementByRandomIndex();
        randomListElement.readElementByRandomIndex();
        randomListElement.readElementByRandomIndex();


        //2
        // Napisz program, który wykonuje operację dzielenia elementów dwóch list.
        // Jeżeli którakolwiek lista będzie krótsza lub wystąpi dzielenie przez zero, obsłuż wyjątki.
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(1, 0, 3, 4, 5);

        ListElementsDivision.listDivision(list1, list2);


        //3
        // Napisz metodę, która pobiera listę dat i zwraca różnicę w dniach między pierwszą a ostatnią datą.
        // Obsłuż wyjątek, gdy lista będzie pusta lub zawiera null.

        List<LocalDate> listDates1 = Arrays.asList(LocalDate.parse("1990-11-11"), LocalDate.parse("1998-11-11"));
        List<LocalDate> listDates2 = Arrays.asList(LocalDate.parse("1990-11-11"), null);
        List<LocalDate> listDates3 = new ArrayList<>();

        System.out.println("Dates");
        System.out.println(DayDifference.dateDifference(listDates1));
        System.out.println(DayDifference.dateDifference(listDates2));
        System.out.println(DayDifference.dateDifference(listDates3));


        //4
        // Napisz metodę, która zapisuje dane użytkownika do pliku. Obsłuż wyjątek, gdy zapis nie będzie możliwy.

//        WriteUserInputs.getAndWriteInputs();

        //5
        // Napisz metodę, która przyjmuje dzień tygodnia w postaci String i konwertuje go na DayOfWeek (enum).
        // Obsłuż wyjątek, gdy podana wartość nie jest poprawnym dniem tygodnia.

        System.out.println("Monday");
        ConvertDateToEnum.convertToDayOfWeek("monday");
        ConvertDateToEnum.convertToDayOfWeek("mondat");

        //6
        // Napisz własny wyjątek InvalidProductCountException, który zostanie rzucony,
        // gdy liczba produktów będzie mniejsza niż 1. Zaimplementuj metodę, która obsługuje ten wyjątek.

        ProductManager.checkProductCount(5);
//        Product.checkProductCount(0);


        //7
        // Napisz metodę, która przyjmuje listę obiektów typu Object i próbuje konwertować je na typ Integer.
        // Obsłuż wyjątek ClassCastException, gdy konwersja nie będzie możliwa.

        ConvertObjectToInteger.convertObject(Arrays.asList(10, 25, 1.1, null));
        //8
        // Napisz metodę, która najpierw próbuje odczytać plik, a następnie parsuje zawartość jako liczby całkowite.
        // Obsłuż wyjątki związane zarówno z odczytem pliku, jak i niepoprawnym formatem danych.

        ParseFileContent.parseFile();

        //9
        //Stworz asocjacje pomiedzy klientem i produktem 1-*. Obsluz sytuacje gdy produkt jest nullem, wtedy automatycznie ustwiamy
        //klientowi ze zamowil lamborghini za 10000000

        Product product1 = new Product("test", 100);
        Client client = new Client("test");

        client.addProduct(product1);
        client.addProduct(null);

        client.printProducts();
    }
}
