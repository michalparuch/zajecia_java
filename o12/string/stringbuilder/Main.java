package basics.o12.string.stringbuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        /*Instancje klasy String reprezentują łańcuchy znaków.
         * Wewnętrznie znaki te przetrzymywane są w tablicy znaków.
         * Tablica ta ma typ char[].
         * Implementacja klasy String chowa przed programistą mechanizmy operowania na tej tablicy.
         * W języku Java Stringi zostały utworzone jako niemodyfikowalne - oznacza, to, że nie możemy na przykład
         * dynamicznie dodawać do tego samego ciągu znaków czegoś nowego,
         * gdy tego dokonujemy, to zawsze tworzymy nowy obiekt String.
         */

        String txt = "Ala ma kota   ";
//        txt += " ale nie ma psa";

        //substring - zwraca pewna czesc lancucha znakow okreslona indeksem
        System.out.println(txt.substring(1));
        System.out.println(txt.substring(1, 5));

        //znaki w dol, znaki w gore
        System.out.println(txt.toLowerCase());
        System.out.println(txt.toUpperCase());

        //trim zwraca nowa instacnje bez poczatkowych i koncowych bialych znakow
        System.out.println(txt.trim());

        // compareTo
        //Por�wnuje dwa stringi leksykograficznie

        //Zwraca 0 jesli Stingi sa takie same
        //liczbe ujemna jesli String z parametru jest wiekszy leksykograficznie
        //liczbe dodatnia jesli String z parametru jest mniejszy leksykograficznie
        //najpierw sa cyfry, potem wielkie litery, potem male
        System.out.println("Compare: " + "abc".compareTo("Abc"));

        //zwraca kod ascii literki o danym indeksie
        System.out.println(txt.codePointAt(0));
        //zwraca kod ascii literki przed danym indeksem
        System.out.println(txt.codePointBefore(1));

        //ignoruje wielkie litery
        System.out.println("abc".compareToIgnoreCase("ABC"));

        //sprawdza czy string zawiera podany ciag znakow
        System.out.println("abcd".contains("bc"));
        System.out.println("abcd".contains("ac"));

        //czy string sie konczy na to co w parametrze
        System.out.println("Ends with " + "abc".endsWith("bc"));
        System.out.println("abc".startsWith("ab"));

        //metoda equals
        System.out.println("abc".equals("abc"));
        System.out.println("ABC".equalsIgnoreCase("abc"));

        String a = "hejka";
        String b = "hejka";
        String c = new String("hejka");

        System.out.println(a == b);
        System.out.println(a == c);

        System.out.println(a.equals(c));

        //wywołując konstruktor poprzez użycie new String() wymuszamy na programie utworzenie nowego obiektu w pamięci.
        // Kiedy wpisujemy String w cudzysłowiach, jest to wartość którą program tworzy i przechowuje w swojej pamięci
        // w tzw string pool. Gdy chcemy utworzyć kolejny obiekt używając tego samego sposobu i wartości,
        // to program sprawdza najpierw czy w string pool taka wartość już się znajduje. Jeśli tak, to mówi "hey,
        // mam już taki obiekt, nie twórzmy nowego" i twojej zmiennej wskazuje adres tego obiektu.
        // Efektem tego jest zwracanie true w przypadku użycia operatora ==. Obiekty tworzone z użyciem
        // słowa kluczowego (czy operatora) "new" nie sięgają do String pool, tylko są przechowywane w heap space.


        //sprawdza czy string sklada sie z samych whitespacow
        System.out.println("is blank: " + " ".isBlank());


        //zwraca indeks wystapienia chara
        System.out.println("Last index: " + "abcde".lastIndexOf('b'));
        System.out.println("Last index: " + "abcdefg".lastIndexOf('c', 1));

        //powtarza kilka razy stringa
        System.out.println("abc".repeat(5));

        System.out.println("SPLIT");
        //splituje stringa wzgledem regexa
        String[] tablica = "ala ma kota".split(" ");


        for (String x : tablica) {
            System.out.println(x);
        }

        // StringBuilder w Javie jest klasą, która umożliwia dynamiczną manipulację łańcuchami znaków.
        // Jest to efektywna alternatywa dla konkatenacji łańcuchów znaków za pomocą operatora +, szczególnie
        // gdy operacje te są wykonywane w pętlach lub w przypadku budowania długich łańcuchów.

        //Główne cechy StringBuilder to:

        // 1) Mutowalność: StringBuilder jest mutowalny, co oznacza, że można modyfikować jego zawartość bez tworzenia nowych obiektów.
        // 2) Efektywność: W przeciwieństwie do konkatenacji za pomocą operatora +, która może prowadzić do tworzenia wielu
        //    zbędnych obiektów łańcuchów, StringBuilder zarządza wewnętrznym buforem, co pozwala na efektywne manipulowanie łańcuchami.
        // 3) Metody manipulacji: Klasa StringBuilder udostępnia wiele przydatnych metod do manipulacji łańcuchami,
        //    takich jak append(), insert(), delete(), replace(), substring() itp., które pozwalają dodawać, wstawiać, usuwać i zastępować części łańcuchów.


        // antyprzyklad - jak NIE uzywac stringbuildera.

        String car = "samochod";
        car = new StringBuilder(car).append(" lambo").toString();
        System.out.println(car);

        car += "ferrari";
        System.out.println(car);

        // porownanie wydajnosci

        String z = "a";
        long start = System.nanoTime(); // metoda .nanoTime() zwraca w miare dokladny czas JVM
        for (int i = 0; i < 10_000; i++) {
            z += "z";
        }
        long czas = System.nanoTime() - start;
        System.out.println("Czas String:       " + czas);


        String g = "a";
        long start2 = System.nanoTime();
        StringBuilder sb = new StringBuilder(g);
        for (int i = 0; i < 10_000; i++) {
            sb.append("z");
        }
        long czas2 = System.nanoTime() - start2;
        System.out.println("Czas StringBuilder: " + czas2);
        System.out.println();


        // Dodawanie znaków i łańcuchów znaków:
        StringBuilder sb4 = new StringBuilder("Hello");

        sb4.append(" World");  // Dodaje podany łańcuch znaków
        sb4.append('!');       // Dodaje podany znak
        sb4.append(new char[]{' ', 'J', 'a', 'v', 'a'});  // Dodaje tablicę znaków
        sb4.append(123);       // Dodaje wartość liczbową
        sb4.append(45.67f);    // Dodaje wartość zmiennoprzecinkową
        sb4.append(true);      // Dodaje wartość logiczną
        System.out.println(sb4);  // Wydrukuje "Hello World! Java12345.67true"


        // Usuwanie znaków:
        StringBuilder sb5 = new StringBuilder("Hello, Java12345.67true World");

        sb5.delete(6, 11);  // Usuwa " Java"
        sb5.deleteCharAt(5);  // Usuwa przecinek

        System.out.println(sb5);  // Wydrukuje "Hello12345.67true World"

        // Zmiana znaków:
        StringBuilder sb6 = new StringBuilder("Hello12345.67true World");

        sb6.setCharAt(5, ',');  // Ustawia przecinek na pozycji 5
        sb6.replace(6, 11, "Java");  // Zamienia "12345" na "Java"

        System.out.println(sb6);  // Wydrukuje "Hello, Java.67true World"

        // Odwracanie znaków:
        StringBuilder sb7 = new StringBuilder("Hello, Java.67true World");

        sb7.reverse();  // Odwraca kolejność znaków

        System.out.println(sb7);  // Wydrukuje "dlroW eurt76.avaJ ,olleH"

        // Konwersja na Stringa
        StringBuilder sb8 = new StringBuilder("Hello, Java.67true World");

        String str = sb8.toString();  // Konwertuje zawartość StringBuilder na String

        System.out.println(str);  // Wydrukuje "Hello, Java.67true World"


        // Uzyskiwanie informacji o stanie StringBuilder:
        StringBuilder sb9 = new StringBuilder("Hello, Java.67true World");

        int length = sb9.length();  // Zwraca długość (liczbę znaków)
        int capacity = sb9.capacity();  // Zwraca aktualną pojemność
        char ch = sb9.charAt(7);  // Zwraca znak na określonej pozycji
        String substr1 = sb9.substring(7);  // Zwraca podciąg znaków od pozycji 7
        String substr2 = sb9.substring(7, 11);  // Zwraca podciąg znaków od pozycji 7 do 11

        System.out.println("Length: " + length);  // Wydrukuje "Length: 23"
        System.out.println("Capacity: " + capacity);  // Wydrukuje pojemność (wartość zależna od implementacji)
        System.out.println("Char at 7: " + ch);  // Wydrukuje "Char at 7: J"
        System.out.println("Substring from 7: " + substr1);  // Wydrukuje "Substring from 7: Java.67true World"
        System.out.println("Substring from 7 to 11: " + substr2);  // Wydrukuje "Substring from 7 to 11: Java"

        // 1. Utwórz dwie zmienne typu String i przypisz im tą samą wartość.
        //    Porównaj je za pomocą operatora ==. Jaki jest efekt?
        // 2. Spróbuj teraaz na jednej zmiennej zastosowac metodę intern(). Czy coś się zmieniło?
        // 3. Jak działa metoda intern()?
        String word1 = "test";
        String word2 = "test";

        String str1 = "test";
        String str2 = new String("test");
        System.out.println(str1 == str2);

        str2 = str2.intern();
        System.out.println(str1 == str2);


        //4
        // Stwórz kolekcję Stringów.
        // Wyświetl wszystkie Stringi odwrócone np kot ma być tok itd.

        List<String> words = new ArrayList<>(Arrays.asList("test1", "test2", "test3"));

        for (String word : words) {
            String reverseWord = new StringBuilder(word).reverse().toString();
            System.out.println(reverseWord);
        }


        //5
        // Przetestuj i porównaj obiekty klasy StringBuffer i StringBuilder.
        // Co wypadnie lepiej w teście szybkości?
        // W klasie StringBuffer też mamy dostępną metodę appened().
        long start1_zad5 = System.nanoTime();

        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 10000; i++) {
            stringBuffer.append("test");
        }
        System.out.println("-----stringBuffer-----");
        System.out.println(System.nanoTime() - start1_zad5);


        long start2_zad5 = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            stringBuilder.append("test");
        }
        System.out.println("-----stringBuilder-----");
        System.out.println(System.nanoTime() - start2_zad5);


        //6
        // Zaimplementuj klasę TextEditor, która umożliwia podstawowe operacje na tekście.
        // Wewnątrz ma wykorzystywać StringBuilder do przechowywania i modyfikacji tekstu.

        TextEditor editor = new TextEditor();

        editor.addText("Hello");
        editor.printText();

        editor.insert(5, " World");
        editor.printText();

        editor.delete(5, 11);
        editor.printText();

        editor.reverse();
        editor.printText();


    }
}