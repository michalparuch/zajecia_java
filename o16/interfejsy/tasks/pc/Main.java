package basics.o16.interfejsy.tasks.pc;

public class Main {
    public static void main(String[] args) {

        // Stwórz klase PC, niech klasa PC przyjmuje marke, cene oraz typ interfejsowy hard drive. Stworz dwie klasy ktore implementuja hard drive np ssd, hdd.
        // Sprawdz jakie obiekty mozesz utworzyc typu PC

        PC pcHDD = new PC("Lenovo", 5000.00, new Hdd());
        PC pcSSD = new PC("ASUS", 8000.00, new Ssd());

        pcHDD.getHardDrive().readData();
        pcSSD.getHardDrive().readData();

    }
}
