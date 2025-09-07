package basics.o15.enumy.person;

public class Main {
    public static void main(String[] args) {

        /*
         * Stworz klase Osoba, imie nazwisko, kolor oczu, kolor wlosow, pomysl co moze byc enumem.
         * Stworz ekstnesje klasy Osoba i napisz metody:
         * Napisz ktora zwraca liste osobo o kolorze oczu  podanym jako parametr
         * Napisz metodę która liczy ile jest osób z kolorem wlosow podanym jako parametr
         * Napisz metodę która zwraca Osobe o najdluzszym nazwisku z oczami podanymi jako parametr
         */

        PersonEnum osoba1 = new PersonEnum("Jan1", "Kowalski", HairColor.BROWN, EyesColor.BLUE);
        PersonEnum osoba2 = new PersonEnum("Jan2", "Kowalski", HairColor.BLONDE, EyesColor.GREEN);
        PersonEnum osoba3 = new PersonEnum("Jan3", "Kowalskiiiiiiiiiiiiiiiii", HairColor.BROWN, EyesColor.BLUE);

        System.out.println(osoba1.getCountOfPersonWithHairColor(HairColor.BROWN));
        System.out.println(osoba1.getPersonWithEyesColor(EyesColor.BLUE));
        System.out.println(osoba1.getPersonWithLongestSurname(EyesColor.BLUE));

    }
}
