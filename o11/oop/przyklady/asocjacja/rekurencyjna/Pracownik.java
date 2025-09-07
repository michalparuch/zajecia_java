package basics.o11.oop.przyklady.asocjacja.rekurencyjna;

import java.util.ArrayList;
import java.util.List;

public class Pracownik {

    private String imie, nazwisko;

    private List<Pracownik> podwladni = new ArrayList<>();
    private Pracownik szef;

    public Pracownik(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    // p1 ma podwladnych p2,p3,p4
    // do p2 dodajemy p5

    public void dodajPodwladnego(Pracownik pracownik) {
        if (!podwladni.contains(pracownik)) {
            podwladni.add(pracownik);
        }

        if(this.getSzef() != null) {
            this.getSzef().getPodwladni().add(pracownik);
        }

        pracownik.setSzef(this);
    }

    public void wyswietlPodwladnych() {
        System.out.println("Podwładni pracownika " + imie + " " + nazwisko + " to: ");
        for (Pracownik podwladny : podwladni) {
            System.out.println(podwladny + " ");
        }
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String toString() {
        return imie + " " + nazwisko;
    }

    public Pracownik getSzef() {
        return szef;
    }

    public List<Pracownik> getPodwladni() {
        return podwladni;
    }

    public void setSzef(Pracownik szef) {
        this.szef = szef;
    }

}
