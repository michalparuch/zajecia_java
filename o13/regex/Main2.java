package basics.o13.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main2 {
    public static void main(String[] args) {

        //grupy oznaczamy ( ) i tworzymy je po to aby moc sie latwo odwolywac do przechwyconcyh wartosci

        // alternatywa czyli |
        Pattern pattern5 = Pattern.compile("skręć w (prawo|lewo)");

        // Użycie metody matches() do sprawdzenia, czy cały tekst pasuje do wzorca
        System.out.println(pattern5.matcher("skręć w lewo").matches());


        // Użycie metody find() do wyszukania wzorca w tekście
        Matcher matcher5 = pattern5.matcher("skręć w lewo");
        System.out.println();

        if (matcher5.find()) {
            System.out.println(matcher5.groupCount());
            System.out.println(matcher5.group(1));
        } else {
            System.out.println("Brak dopasowania");
        }
        System.out.println();


        String text = "The rain in Spain stays mainly in the plain.";
        String regex = "\\bin\\b"; // Słowo "in"

		/*
		\\b:

		To oznacza granicę słowa (word boundary).
		Granica słowa to miejsce w tekście, gdzie następuje przejście między znakami
		alfanumerycznymi ([a-zA-Z0-9_]) a znakami niealfanumerycznymi (np. spacja, przecinek) lub początkiem/końcem tekstu.
		 */

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println("Found at: " + matcher.start() + " - " + matcher.end());
        }
        System.out.println();

		/*
		W Javie start() i end() to metody klasy Matcher, używane do określenia pozycji
		dopasowania w tekście. Obie odnoszą się do aktualnie znalezionego dopasowania (czyli tego, które zostało znalezione ostatnio przez find()).
		 */


        		/*
		groupCount():
		Zwraca liczbę grup wychwytujących (ang. capturing groups) w wyrażeniu regularnym.

		Każda para nawiasów jest numerowana:
		- group(0) odnosi się do całego dopasowania.
		- group(1) do pierwszej grupy wychwytującej, group(2) do drugiej itd.
		 */


        String text2 = "John (Doe), age 30, lives in City (London).";
        String regex2 = "(\\w+)\\s\\((\\w+)\\)";

        Pattern pattern2 = Pattern.compile(regex2);
        Matcher matcher2 = pattern2.matcher(text2);

        while (matcher2.find()) {
            System.out.println("Matched: " + matcher2.group(0));
            System.out.println("Group count: " + matcher2.groupCount());
            System.out.println("First group: " + matcher2.group(1));
            System.out.println("Second group: " + matcher2.group(2));
            System.out.println();
        }

        Pattern pattern6 = Pattern.compile("pies|ala|kot");

        // Użycie metody matches() do sprawdzenia, czy cały tekst pasuje do któregokolwiek z alternatyw
        System.out.println(pattern6.matcher("pies").matches());
        System.out.println(pattern6.matcher("skręć w prawo kot").matches());
        System.out.println();

        // grupy nazwane
		/*
		Grupy używane w wyrażeniach regularnych można również nazywać. Dzięki temu zawartość takiej
		grupy można odczytać w tradycyjny sposób, korzystając z jej indeksu, albo odwołując się do niej po nazwie.
		Poniżej znajduje się przykład, w którym nazwane grupy przechowują poszczególne elementy daty.
		 */

        Pattern pattern8 = Pattern.compile("(?<day>\\d{2}).(?<month>\\d{2}).(?<year>\\d{4})");

        Matcher matcher8 = pattern8.matcher("04.01.2017");
        if (matcher8.matches()) {
            System.out.println(matcher8.group("day"));
            System.out.println(matcher8.group("month"));
            System.out.println(matcher8.group("year"));
            System.out.println(matcher8.group(1));
            System.out.println(matcher8.group(2));
            System.out.println(matcher8.group(3));
            System.out.println();
        } else {
            System.out.println("No match in date!");
        }

        System.out.println("---------------- ZACHLANNOSC ----------------");
		/*
		Wyrażenia regularne mają zachłanny charakter, co oznacza, że próbują dopasować jak największy
		fragment łańcucha znaków, który spełnia podany wzorzec. Najlepiej zrozumieć to na konkretnym przykładzie.
		 */

        Pattern pattern3 = Pattern.compile("<(.+)>");
        Matcher matcher3 = pattern3.matcher("<html>some emphasized text</html>");
        matcher3.find();
        System.out.println(matcher3.group(1));

        System.out.println("---------------- ZACHLANNOSC OFF ----------------");

		/*
		Wyrażenia regularne działają w sposób zachłanny, ponieważ mechanizm obsługujący powtórzenia dąży do
		dopasowania jak największego fragmentu tekstu. Symbole powtórzeń takie jak {}, ?, * czy +
		domyślnie starają się objąć możliwie najwięcej znaków.
		 */


        // znak ? wylacza zachłannosc wyrazen regularnych

        Pattern pattern31 = Pattern.compile("<(.+?)>");
        Matcher matcher31 = pattern31.matcher("<html>some emphasized text</html>");
        matcher31.find();
        System.out.println(matcher31.group(1));

        		/*
		Tym razem konstrukcja .+ nie dopasowała prawie całego łańcucha, ponieważ została użyta w sposób niezachłanny.
		Grupa przechwyciła minimalną ilość tekstu spełniającego wzorzec.
		Podobnie znak ? może wyłączać zachłanność operatora *.
		 */

        Pattern pattern61 = Pattern.compile("<(.*?)>");
        Matcher matcher6 = pattern61.matcher("<html>some emphasized text</html>");
        matcher6.find();
        System.out.println(matcher6.group(1));
        System.out.println();

        System.out.println("---------");


        // \\ oznacza odwolanie sie do 1 grupy
        Pattern pattern28 = Pattern.compile("<(.+)>(.+)<(/\\1)>"); // \\1 to odwołanie do pierwszej grupy przechwytującej - chodzi o dokladnie taka sama wartosc
        Matcher matcher28 = pattern28.matcher("<html>bla bla bla<body>bla bla</body></html>");
        matcher28.find();
        System.out.println(matcher28.group(1));
        System.out.println(matcher28.group(2));
        System.out.println(matcher28.group(3));

        System.out.println();

        System.out.println("---------------- KOTWICE ----------------");
        // kotwice
		/*
		Teraz omówimy kotwice, czyli specjalne znaki używane w wyrażeniach regularnych. Kotwice określają,
		w którym miejscu łańcucha znaków powinno nastąpić dopasowanie.
		Na przykład wzorzec c$ pasuje do ciągów takich jak abc czy bac, ale nie do cab. Oznacza to, że $ wskazuje,
		iż znak c musi znajdować się na końcu łańcucha.

		Najczęściej używane kotwice to:

		^ — oznacza początek łańcucha znaków.
		$ — oznacza koniec łańcucha znaków.
		 */

        // Wyrażenie sprawdza, czy na początku tekstu znajduje się cyfra.
        Pattern pattern10 = Pattern.compile("^\\d");
        Matcher matcher10 = pattern10.matcher("1ab12");
        System.out.println(matcher10.find());

        // Wyrażenie sprawdza, czy tekst zaczyna się od "c" i ma co najmniej jeden dowolny znak po "c", aż do końca tekstu.
        Pattern pattern11 = Pattern.compile("^c.+$");
        Matcher matcher11 = pattern11.matcher("cbcs");
        System.out.println(matcher11.find());

        // Wyrażenie sprawdza, czy cały tekst składa się wyłącznie z cyfr.
        Pattern pattern12 = Pattern.compile("^\\d+$");
        Matcher matcher12 = pattern12.matcher("12d3");
        System.out.println(matcher12.find());

    }
}
