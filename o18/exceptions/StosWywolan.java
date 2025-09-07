package basics.o18.exceptions;

public class StosWywolan {
    public static void main(String[] args) {
        StosWywolan stosWywolan = new StosWywolan();
        stosWywolan.metoda1();

    }

    public void metoda1() {
        metoda2();
    }

    public void metoda2() {
        metoda3();
    }

    public void metoda3() {
        throw new RuntimeException("wyjatek runtime");
    }
}
