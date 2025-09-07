package basics.o19.dates.zadania.z4.turniej;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        /*
         * Stwórz klasę gracz (imię, nazwisko, nick)
         * Stworz klasę turniej. Musimy przechowywac nazwe, wpisowe, data, punkty
         *
         * Gracz dostaje punkty za dane miejsce w turnieju, w roznych turniejach moga byc rozne ilosci
         * punktow za rozne miejsca.
         *
         *
         * Napisz metode która znajduje najlepszego gracza z danego miesiąca. // 1
         * Napisz metode ktora znajduje najlepszego gracza z danego okresu czasu.
         * Napisz metode ktora znajduje graczy z danego okresu czasu.
         * Napisz metoda która zwraca liste graczy którzy zajeli 1 miejsce przynajmniej w dwoch roznych miesiącach
         */

        Player player1 = new Player("Jan", "Jan1", "Kowalski");
        Player player2 = new Player("Adam", "Adam2", "Nowak");
        Player player3 = new Player("Ola", "Ola3", "Wiśniewska");

        new Tournament("Turniej Styczeń", 10, LocalDate.of(2025, 1, 15), "100 PLN", player1);
        new Tournament("Turniej Styczeń", 15, LocalDate.of(2025, 1, 15), "100 PLN", player2);
        new Tournament("Turniej Luty", 20, LocalDate.of(2025, 2, 10), "200 PLN", player1);
        new Tournament("Turniej Luty", 5, LocalDate.of(2025, 2, 10), "200 PLN", player3);
        new Tournament("Turniej Marzec", 30, LocalDate.of(2025, 3, 5), "150 PLN", player2);
        new Tournament("Turniej Marzec", 25, LocalDate.of(2025, 3, 5), "150 PLN", player3);


        // 1. Najlepszy gracz w styczniu
        Player bestJan = Player.getBestPlayerByMonth(1);
        System.out.println("Najlepszy gracz w styczniu: " + bestJan.getNick());

        // 2. Najlepszy gracz w okresie (styczeń-marzec)
        Player bestPeriod = Player.getBestPlayerByTimePeriod(
                LocalDate.of(2025, 1, 1),
                LocalDate.of(2025, 3, 31)
        );
        System.out.println("Najlepszy gracz w okresie I-III 2025: " + bestPeriod.getNick());

        // 3. Gracze biorący udział w lutym i marcu
        Set<Player> playersInPeriod = Player.getPlayersByTimePeriod(
                LocalDate.of(2025, 2, 1),
                LocalDate.of(2025, 3, 31)
        );
        System.out.println("Gracze grający w lutym/marcu:");
        for (Player player : playersInPeriod){
            System.out.println(" - " + player.getNick());
        }

        // 4. Gracze z 1. miejscem w co najmniej dwóch różnych miesiącach
        List<Player> winners2Months = Player.getPlayersWithWinsInTwoDifferentMonths();
        System.out.println("Gracze z 1. miejscem w >= 2 miesiącach:");
        for (Player player : winners2Months){
            System.out.println(" - " + player.getNick());
        }

    }
}
