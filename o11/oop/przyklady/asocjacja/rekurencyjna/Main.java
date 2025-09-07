package basics.o11.oop.przyklady.asocjacja.rekurencyjna;

public class Main {
    public static void main(String[] args) {

        // stworz 5 pracownikow, p1 ma podwladnych p2 p3 p4, a p2 ma podwladnego p5, na koniec wypisz wszystkich podwladnych p1

        Pracownik p1 = new Pracownik("Jan", "Kowalski_1");
        Pracownik p2 = new Pracownik("Jan", "Kowalski_2");
        Pracownik p3 = new Pracownik("Jan", "Kowalski_3");
        Pracownik p4 = new Pracownik("Jan", "Kowalski_4");
        Pracownik p5 = new Pracownik("Jan", "Kowalski_5");

        p1.dodajPodwladnego(p2);
        p1.dodajPodwladnego(p3);
        p1.dodajPodwladnego(p4);

        p2.dodajPodwladnego(p5);

        p1.wyswietlPodwladnych();
    }
}
