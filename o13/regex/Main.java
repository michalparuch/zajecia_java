package basics.o13.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        		/*
		Wyrażenia regularne, często nazywane w skrócie "regex" (od ang. regular expressions),
		to specjalny sposób tworzenia wzorców, które pozwalają na wyszukiwanie, dopasowywanie i manipulowanie tekstem.
		Regex to narzędzie wykorzystywane w programowaniu, które umożliwia szybkie sprawdzenie, czy ciąg znaków
		pasuje do określonego wzorca, a także przeprowadzanie operacji na tym ciągu, jak jego modyfikacja
		czy ekstrakcja części tekstu.
		 */

        Pattern compiledPattern = Pattern.compile("Marcin");

        // W kolejnej linijce wywołując metodę matcher otrzymuję instancję klasy Matcher. Parametr przekazany w metodzie matcher to łańcuch znaków,
        // na którym używamy wyrażenia regularnego.
        Matcher matcher = compiledPattern.matcher("Marcin ma Volvo");

                /*
        Działanie: Metoda find() wyszukuje pierwsze dopasowanie wzorca w danym ciągu tekstowym.
        Zwraca true jeśli znajdzie przynajmniej jedno dopasowanie, a false jeśli nie znajdzie żadnego.

		Zastosowanie: Używamy jej, gdy chcemy znaleźć dowolne wystąpienie wzorca w tekście,
		niezależnie od tego, co znajduje się przed lub po nim. Możemy jej używać wielokrotnie, aby znaleźć kolejne dopasowania.
         */
        System.out.println(matcher.find());


               	/*
       	Działanie: Metoda matches() sprawdza, czy cały ciąg tekstowy pasuje do wzorca.
       	Zwraca true jeśli cały tekst pasuje do wzorca, a false jeśli jakakolwiek część tekstu nie pasuje.

		Zastosowanie: Używamy jej, gdy chcemy sprawdzić, czy cały tekst spełnia określony wzorzec,
		 np. przy walidacji pełnych danych wejściowych.
       	 */
        System.out.println(matcher.matches());


        /*
         * Znak ? oznacza, że element przed nim jest opcjonalny, co oznacza, że może wystąpić raz lub wcale.
         * Na przykład wyrażenie regularne "co?lor" dopasowuje zarówno "color", jak i "clor", ale nie dopasuje "coolor" ani "clr".
         */
        System.out.println();

        System.out.println("co?lor");
        Pattern pattern = Pattern.compile("co?lor");
        System.out.println(pattern.matcher("color").matches()); // true
        System.out.println(pattern.matcher("clor").matches()); // true
        System.out.println(pattern.matcher("colr").matches());  // false
        System.out.println(pattern.matcher("coolor").matches()); // false
        System.out.println();

        /*
         * Znak * oznacza, że element znajdujący się przed nim może być powtórzony dowolną liczbę razy, w tym 0 razy.
         * Na przykład wyrażenie regularne "ha*ha" dopasowuje "hha", "haha", "haaaaha", ale nie dopasuje "hahahahha".
         */
        System.out.println("ha*ha");
        Pattern pattern2 = Pattern.compile("ha*ha");
        System.out.println(pattern2.matcher("hha").matches());       // true
        System.out.println(pattern2.matcher("haha").matches());      // true
        System.out.println(pattern2.matcher("haaaaha").matches());   // true
        System.out.println(pattern2.matcher("hahahahha").matches()); // false
        System.out.println();

        /*
         * Znak + oznacza, że element znajdujący się przed nim musi wystąpić co najmniej raz (1 lub więcej razy).
         * Na przykład wyrażenie regularne "go+al" dopasowuje "goal", "goooal", ale nie dopasuje "gal".
         */
        System.out.println("go+al");
        Pattern pattern3 = Pattern.compile("go+al");
        System.out.println(pattern3.matcher("goal").matches()); //true
        System.out.println(pattern3.matcher("goooal").matches()); //true
        System.out.println(pattern3.matcher("gal").matches()); //false
        System.out.println();

        /*
         * Znak . oznacza dowolny pojedynczy znak (z wyjątkiem znaku nowej linii).
         * Na przykład wyrażenie regularne "ja.a" dopasowuje "jaba", "jama", ale nie dopasuje "jaa" ani "jabba".
         */
        System.out.println("ja.a");
        Pattern pattern7 = Pattern.compile("ja.a");
        System.out.println(pattern7.matcher("jaba").matches());    // true
        System.out.println(pattern7.matcher("jama").matches());    // true
        System.out.println(pattern7.matcher("jaa").matches());     // false
        System.out.println(pattern7.matcher("jabba").matches());   // false
        System.out.println();


        /*
         * Znak {x} oznacza, że element poprzedzający musi wystąpić dokładnie x razy.
         * Znak {x,} oznacza, że element poprzedzający musi wystąpić co najmniej x razy.
         * Znak {x,y} oznacza, że element poprzedzający musi wystąpić od x do y razy.
         * Poniżej znajdują się przykłady użycia tych zapisów:
         */

        // {x} – oznacza, że element poprzedzający musi wystąpić dokładnie x razy
        Pattern pattern4 = Pattern.compile("Krzysz{4}tof");
        System.out.println(pattern4.matcher("Krzyszzzztof").matches());  // false - "z" występuje 4 razy, ale nie pasuje do "Krzyszzzztof"
        System.out.println(pattern4.matcher("Krzyszzztof").matches());   // true - "z" występuje dokładnie 4 razy

        System.out.println();

        // {x,} – oznacza, że element poprzedzający musi wystąpić co najmniej x razy
        Pattern pattern5 = Pattern.compile("Krzysz{4,}tof");
        System.out.println(pattern5.matcher("Krzyszzzztof").matches());  // true - "z" występuje co najmniej 4 razy
        System.out.println(pattern5.matcher("Krzyszzzzzzztof").matches());  // true - "z" występuje więcej niż 4 razy

        System.out.println();

        // {x,y} – oznacza, że element poprzedzający musi wystąpić od x do y razy
        Pattern pattern6 = Pattern.compile("Krzysz{4,9}tof");
        System.out.println(pattern6.matcher("Krzyszzzzzzzzzzztof").matches());  // false - "z" występuje więcej niż 9 razy
        System.out.println(pattern6.matcher("Krzyszzzztof").matches());   // true - "z" występuje dokładnie 4 razy

        System.out.println();


        System.out.println("k+a.*ta");
        Pattern pattern8 = Pattern.compile("k+a.*ta");

        System.out.println(pattern8.matcher("kkkatapulta").matches()); //true
        System.out.println(pattern8.matcher("kkkaaaatzafpulta").matches()); //true
        System.out.println(pattern8.matcher("karta").matches());//true
        System.out.println(pattern8.matcher("kasia ma kota").matches());//true
        System.out.println(pattern8.matcher("kkkka#$*&JHDFSta").matches());//true
        System.out.println(pattern8.matcher("ata").matches());//false
        System.out.println(pattern8.matcher("kta").matches());//false
        System.out.println();

        /*
         * Znak + oznacza, że poprzedzający go element (w tym przypadku "k") musi wystąpić co najmniej raz.
         * Znak * oznacza, że poprzedzający go element (w tym przypadku ".") może wystąpić dowolną liczbę razy (w tym 0 razy).
         * Znak . oznacza dowolny znak (poza znakiem nowej linii).
         * Wyrażenie "k+a.*ta" dopasuje takie ciągi jak "kkkatapulta", "kkkaaaatzafpulta" czy "karta", ale nie dopasuje "ata" ani "kta".
         */

        		   /*
		klasy znaków to mechanizm umożliwiający zdefiniowanie grup znaków, które są dopasowywane w danym miejscu wyrażenia regularnego.
		Klasy znaków są używane do wskazania zestawu znaków, które mogą być użyte jako dopasowanie.

        Klasy znaków w wyrażeniach regularnych:
    	[ ] - Definiują grupę znaków do dopasowania:

    	[A-E]  - Dowolna wielka litera od A do E (A, B, C, D, E).
    	[h-u]  - Dowolna mała litera od h do u (h, i, j, ..., u).
    	[A-Cg-z] - Wielka litera A-C lub mała litera g-z (A, B, C, g, h, ..., z).
    	[H-g]  - Wielka litera H-Z lub mała litera a-g (H, I, ..., Z, a, b, ..., g).
    	[3-8]  - Dowolna cyfra od 3 do 8 (3, 4, 5, 6, 7, 8).
    	[^a-c] - Dowolny znak poza literami a, b, c (np. d, z, 1, @, ...).
     */

        /*
         * Predefiniowane klasy znaków w wyrażeniach regularnych:
         *
         * \\d - Pasuje do każdej cyfry, czyli jest równoważne z [0-9].
         * \\D - Pasuje do każdego znaku, który nie jest cyfrą, czyli jest zaprzeczeniem grupy \d, równoważne z [^0-9].
         * \\w - Pasuje do każdego znaku używanego w słowach, czyli do liter (zarówno wielkich, jak i małych), cyfr oraz podkreślnika (_). Jest równoważne z [A-Za-z0-9_].
         * \\W - Pasuje do każdego znaku, który nie jest znakiem słowa, czyli zaprzeczenie \w, równoważne z [^A-Za-z0-9_].
         * \\s - Pasuje do każdego znaku białego (whitespace), czyli spacji, tabulacji, nowej linii, powrotu karetki, form feed (przerwa stron) oraz vertical tab (tabulator pionowy). Jest równoważne z [ \t\n\r\f\x0B].
         * \\S - Pasuje do każdego znaku, który nie jest białym znakiem, czyli zaprzeczenie \s.
         */

        Pattern pattern9 = Pattern.compile("[a-d]uma");
        System.out.println(pattern9.matcher("duma").matches());
        System.out.println(pattern9.matcher("puma").matches());
        System.out.println();

        Pattern pattern10 = Pattern.compile("[0-7]zyx");
        System.out.println(pattern10.matcher("0zyx").matches());
        System.out.println(pattern10.matcher("9zyx").matches());
        System.out.println();

        Pattern pattern11 = Pattern.compile("[a-cA-C0-3]dup");
        System.out.println(pattern11.matcher("adup").matches());
        System.out.println(pattern11.matcher("Cdup").matches());
        System.out.println();

        Pattern pattern12 = Pattern.compile("[^xyz]awa");
        System.out.println(pattern12.matcher("aawa").matches());
        System.out.println(pattern12.matcher("zawa").matches());
        System.out.println();

        // stworz pattern na imie
//        Pattern imieNazwisko = Pattern.compile("[A-Z][a-z]+");

        // stwórz pattern na imie i nazwisko
        Pattern imieNazwisko = Pattern.compile("([A-Z][a-z]+)+(\\s)+([A-Z][a-z]+.*)+([a-z])");

        System.out.println(imieNazwisko.matcher("Grzegorz Popiolek-Krzys").matches()); // tru
//        System.out.println(imieNazwisko.matcher("Grzegorz").matches()); // tru
        System.out.println(imieNazwisko.matcher("Tomek Osinski").matches());         // true
        System.out.println(imieNazwisko.matcher("John Doe").matches());             // true
        System.out.println(imieNazwisko.matcher("Grzegorz popiolek").matches());    // false
        System.out.println();


        //napisz pattern na datę w postaci xx-xx-xxxx
        Pattern data = Pattern.compile("\\d{2}-\\d{2}-\\d{4}");

        System.out.println(data.matcher("15-07-2025").matches());
        System.out.println();

        //napisz pattern na maila

        Pattern email = Pattern.compile("\\w+\\.*[a-z]*@[a-z]+\\.[a-z]+\\.?[a-z]+");

        System.out.println("---email-----");
        System.out.println(email.matcher("michal@gmail.com").matches());
        System.out.println(email.matcher("2gp@op.com").matches());         // true
        System.out.println(email.matcher("gp2341asd@gmail.com").matches()); // true
        System.out.println(email.matcher("tomek.jablonski@onet.pl").matches()); // true
        System.out.println(email.matcher("tomek@com").matches());          // false
        System.out.println();

        // domowe

        //1
        // Sprawdź, czy liczba podana przez użytkownika ma poprawny format.
        // Na przykład liczba 123,2341515132135 lub -10 jest poprawna, ale ciąg znaków 18-12 czy 123, już nie.
        Pattern patternZad1 = Pattern.compile("-?\\d+\\.?\\d*");
        System.out.println("----zad1----");
        System.out.println(patternZad1.matcher("123").matches());
        System.out.println(patternZad1.matcher("-123").matches());
        System.out.println(patternZad1.matcher("123.123").matches());
        System.out.println(patternZad1.matcher("-123.123").matches());
        System.out.println(patternZad1.matcher("18-12").matches());


        //2
        // Sprawdź, czy numer domu jest w formacie numer\numer.
        // Poprawnym numerem jest 123\2A, 24B\3 czy 12\5, ale numer abc\cba nie jest poprawny.
        Pattern patternZad2 = Pattern.compile("\\d+[A-Za-z]*\\\\\\d+[A-Za-z]*");
        System.out.println("----zad2----");
        System.out.println(patternZad2.matcher("123\\2A").matches());
        System.out.println(patternZad2.matcher("24B\\3").matches());
        System.out.println(patternZad2.matcher("12\\5").matches());
        System.out.println(patternZad2.matcher("abc\\cba").matches());


        //3
        //napisz pattern na miasto np Warszawa, Bielsko-Biala, Zielona Gora
        Pattern patternZad3 = Pattern.compile("[A-Z][a-z]+-?[A-Z]?[a-z]*\\s?[A-Z]?[a-z]*");

        System.out.println("----zad3----");
        System.out.println(patternZad3.matcher("Warszawa").matches());
        System.out.println(patternZad3.matcher("Bielsko-Biala").matches());
        System.out.println(patternZad3.matcher("Zielona Gora").matches());

        //4
        // Stwórz wyrażenie regularne, które pasuje do numeru telefonu w formacie "123-456-789",
        // gdzie każda część składa się z trzech cyfr.
        Pattern patternZad4 = Pattern.compile("\\d{3}-\\d{3}-\\d{3}");

        System.out.println("----zad4----");
        System.out.println(patternZad4.matcher("123-123-123").matches());
        System.out.println(patternZad4.matcher("12-123-13").matches());
        System.out.println(patternZad4.matcher("1212313").matches());

        //5
        // Stwórz wyrażenie regularne, które pasuje do prostego adresu
        // URL, np. "http://www.example.com" lub "https://example.com".
        Pattern patternZad5 = Pattern.compile("https?://[A-Za-z0-9]+\\.?[A-Za-z0-9]+\\.[A-Za-z]+");

        System.out.println("----zad5----");
        System.out.println(patternZad5.matcher("http://www.example.com").matches());
        System.out.println(patternZad5.matcher("https://example.com").matches());


        //6
        // Stwórz wyrażenie regularne, które pasuje do polskiego kodu pocztowego w formacie "00-000".
        Pattern patternZad6 = Pattern.compile("\\d{2}-\\d{3}");

        System.out.println("----zad6----");
        System.out.println(patternZad6.matcher("00-000").matches());
        System.out.println(patternZad6.matcher("100-000").matches());

        //7
        //  Stwórz wyrażenie regularne, które pasuje do godziny w formacie "HH:MM",
        //  gdzie HH to godziny od 00 do 23, a MM to minuty od 00 do 59.
        Pattern patternZad7 = Pattern.compile("(1\\d|2[0-3]):[0-5]\\d");

        System.out.println("----zad7----");
        System.out.println(patternZad7.matcher("12:30").matches());
        System.out.println(patternZad7.matcher("30:30").matches());

        //8
        //  Stwórz wyrażenie regularne, które pasuje do adresu strony WWW z rozszerzeniem .com, .org lub .net.
        Pattern patternZad8 = Pattern.compile("https?://www\\.[A-Za-z0-9]+\\.(com|org|net)");

        System.out.println("----zad8----");
        System.out.println(patternZad8.matcher("http://www.example.com").matches());
        System.out.println(patternZad8.matcher("http://www.example.org").matches());
        System.out.println(patternZad8.matcher("http://www.example.net").matches());
        System.out.println(patternZad8.matcher("http://www.example.pl").matches());


    }
}
