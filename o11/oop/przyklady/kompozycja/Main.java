package basics.o11.oop.przyklady.kompozycja;

public class Main {
    public static void main(String[] args) {

        Pool pool1 = new Pool("Pool1", "10");

        Island island1 = new Island("Island1", pool1, "10");
        Island island2 = new Island("Island2", pool1, "10");
        Island island3 = new Island("Island3", pool1, "10");

        System.out.println(pool1.getListOfIsland());
    }

    // klasa Pool, ma List<Island>, name, area
    // klasa Island, pola Pool, name, area

    // tworzac Island od razu w konstruktorze zwrotnie wywolujemy metode z Basenu, ktora dodaje Basenowi ta tworzona wyspe

//    w obu toString

    // stworzyc basen, 3 wyspy, drukac wyspy basenu

}
