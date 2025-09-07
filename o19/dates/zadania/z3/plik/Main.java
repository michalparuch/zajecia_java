package basics.o19.dates.zadania.z3.plik;

public class Main {
    public static void main(String[] args) {

        // 1 ETAP stworz sobie jakis plik z liczbami, kazda linia w pliku ma zawierac
        // jakas
        // liczbe ktora ma np: 100 znakow niech plik ma 100 linii(randomowe liczby, rozne od siebie), ale
        // przed linia ma byc zapisana godzina zapisu (z dokladnoscia co do milisekund)
        // 2 ETAP Wczytaj te liczby z pliku i zapisz iloczyn tych liczb do pliku
        // wynik.txt a na
        // koncu masz zapisac ile trwały wszystkie obliczenia :)

        FileGenerator.generateFile("liczbyCzasTest.txt");
        FileRead.multiplyNumbers("liczbyCzasTest.txt", "Wyniki_liczb_czas.txt");
    }
}
