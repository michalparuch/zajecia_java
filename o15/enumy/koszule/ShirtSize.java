package basics.o15.enumy.koszule;

public enum ShirtSize {

    /*
     * Podobnie jak w przypadku normalnych klas tak i w przypadku typów wyliczeniowych może on posiadać atrybuty czy metody.
     *  Możesz także stworzyć klasę wyliczeniową, która będzie miała swój własny konstruktor inny od domyślnego.
     *  Spójrz na przykład poniżej, w którym nowe wartości typu wyliczeniowego tworzone są przy pomocy własnego konstruktora.
     *  Każda z wartości przekazuje do konstruktora trzy parametry:
     */


    S(48, 71, 36),
    M(52, 74, 38),
    L(56, 76, 41),
    XL(61, 79, 41);

    private int obwodKlatki, dlugoscKoszulki, dlugoscRekawa;

    ShirtSize(int obwodKlatki, int dlugoscKoszulki, int dlugoscRekawa) {
        this.obwodKlatki = obwodKlatki;
        this.dlugoscKoszulki = dlugoscKoszulki;
        this.dlugoscRekawa = dlugoscRekawa;
    }

    public int getObwodKlatki() {
        return obwodKlatki;
    }

    public int getDlugoscKoszulki() {
        return dlugoscKoszulki;
    }

    public int getDlugoscRekawa() {
        return dlugoscRekawa;
    }

    @Override
    public String toString() {
        return "ShirtSize{" + name() +
                " obwodKlatki=" + obwodKlatki +
                ", dlugoscKoszulki=" + dlugoscKoszulki +
                ", dlugoscRekawa=" + dlugoscRekawa +
                '}';
    }

    /*
     * Dzięki dodaniu atrybutów do typu wyliczeniowego wszystkie potrzebne dane
     * związane z jednym rozmiarem mamy zgrupowane w jednym miejscu.
     *
     * Każdy typ wyliczeniowy, który napiszesz domyślnie tworzony jest jako typ
     * final. Ograniczone są także modyfikatory dostępu, które możesz użyć, w
     * przypadków enumów dopuszczalny jest wyłącznie modyfikator public lub brak
     * jakiegokolwiek modyfikatora dostępu.
     *
     * Typ wyliczeniowy nie może określić żadnej nadklasy po której dziedziczy.
     * Dzieje się tak ponieważ każdy enum domyślnie dziedziczy po java.lang.Enum.
     * Dzięki tej nadklasie wszystkie typy wyliczeniowe zyskują kilka dodatkowych
     * metod opisanych w kolejnych akapitach.
     */


}
