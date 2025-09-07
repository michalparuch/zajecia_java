package basics.o18.exceptions.tasks.shops;

public class Main {
    public static void main(String[] args) {

        // Stworz klase Osoba (imie, nazwisko, miasto, wiek) oraz Sklep (nazwa, miasto)
        // - metoda co zwraca najstarsza kobiete lub NoWomenException jesli brak kobiet na liscie
        // - kobiety chodza do sklepow, mezczyzni nie, zatem powiazania ze sklepem moga miec tylko kobiety, w przypadku próby dodania powiazania mezyczyzna
        //   sklep rzuc wyjatkiem ShopsAreOnlyForWomenException()
        // - osoby moga sie umawiac na randki, ale jestesmy homofobami, nie akceptujemy par homo, dodaj osobie plec
        // przy probie umowienia sie na randke pary homo rzuc wyjatkiem NoHomoHereException()
        // - nasz system przechowuje tylko osoby pełnoletnie, zatem wiek > 18, przy próbie tworzenia osoby która ma mniej niz 18 lat
        // progarm powinien to naprawic, ustawiajac danej osobie 18 lat


        Person p1 = new Person("Anna", "Kowalska", 25, Sex.FEMALE, "Warszawa");
        Person p2 = new Person("Marek", "Nowak", 17, Sex.MALE, "Kraków");
        Person p3 = new Person("Ewa", "Wiśniewska", 30, Sex.FEMALE, "Poznań");

        System.out.println(p1.getName() + " " + p1.getAge());
        System.out.println(p2.getName() + " " + p2.getAge());


        Shop shop = new Shop("Test", "Warszawa");

        try {
            shop.addClient(p1);
            shop.addClient(p2);
        } catch (ShopsAreOnlyForWomenException e) {
            System.out.println(e.getMessage());
        }


        try {
            p1.goOnDate(p3);
        } catch (NoHomoHereException e) {
            System.out.println(e.getMessage());
        }

        try {
            Person oldestWoman = p1.getOldestWoman();
            System.out.println(oldestWoman.getName() + " " + oldestWoman.getAge());
        } catch (NoWomenException e) {
            System.out.println(e.getMessage());
        }

    }
}
