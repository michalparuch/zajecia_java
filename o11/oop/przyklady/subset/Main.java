package basics.o11.oop.przyklady.subset;

public class Main {
    public static void main(String[] args) {

//        klasa Player, ma name, lastName, List<Team> i standardowo konstrutkor gettery settery toString

        // klasa Team, ma name; List<Player> players, List<Player> trainers.
        // Zawodnik moze zostac trenerem druzyny tylko i wylacznie, jesli jesli juz wczesniej zwyklym zawodnikiem - wylacznie awans wewnetrzny
        // standardowo konstrutkor gettery settery toString

        Player player1 = new Player("Jan", "Janowski");
        Player player2 = new Player("Tomek", "Tomkowski");

        Team team1 = new Team("Testowy team");

        team1.addPlayer(player1);
        team1.addTrainer(player1);
        team1.addTrainer(player2);

    }
}
