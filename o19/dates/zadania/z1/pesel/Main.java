package basics.o19.dates.zadania.z1.pesel;

public class Main {
    public static void main(String[] args) {

        /*
         * Stwórz klase Osoba, która ma imie, nazisko, pesel (na jego podstawie tworzymy
         * date urodzenia). Stwórz klase Lokal, który ma nazwe, miejsce i minimalny wiek
         * zeby wejsc.
         *
         * Przy próbie wejscia, jesli osoba sie nie łapie na minimalny wiek (ustalamy go
         * z peselu podanego jako string) rzuc wyjatkiem ze jestesZaMlodyZiom().
         */

        Person person1 = new Person("Michal", "P", "98112344444");
        Person person2 = new Person("Michal", "P", "09112344444");

        Local local = new Local("Bar", "WWA", 18);

        person1.enterLocal(local);
        person2.enterLocal(local);
    }
}
