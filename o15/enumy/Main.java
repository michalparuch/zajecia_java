package basics.o15.enumy;

public class Main {
    public static void main(String[] args) {

                  /*
    W Javie enum to specjalny typ danych, który reprezentuje stały zbiór wartości. Enumy są często używane,
    gdy istnieje potrzeba określenia zbioru stałych, takich jak dni tygodnia, kierunki, kolory czy stany aplikacji.
    Enumy zostały wprowadzone w Javie 5 i są częścią pakietu java.lang, więc nie trzeba ich importować.

    1) Enum jest klasą specjalną, która rozszerza klasę java.lang.Enum.
    2) Enumy mogą zawierać:
        Stałe (elementy typu enum),
        Pola,
        Metody,
        Konstruktory (prywatne lub domyślne).
    3) Elementy enum są automatycznie publiczne, statyczne i finalne.
     */
        Weekday today = Weekday.MONDAY;
        switch (today) {
            case MONDAY -> System.out.println("Time to work!");
            case SATURDAY, SUNDAY -> System.out.println("Weekend!");
            default -> System.out.println("Regular day.");
        }

        Color color = Color.RED;

        System.out.println("Selected color: " + color);
        System.out.println("Color code: " + color.getColorCode());

    }


    public enum Weekday {
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY;
    }

    public enum Color {
        RED("#FF0000"),
        GREEN("#00FF00"),
        BLUE("#0000FF");

        private final String colorCode;

        // Musi byc prywatny lub package-private
        Color(String colorCode) {
            this.colorCode = colorCode;
        }

        public String getColorCode() {
            return colorCode;
        }
    }

}
