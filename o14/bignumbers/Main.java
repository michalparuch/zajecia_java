package basics.o14.bignumbers;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) {

                /*
        BigNumbers w Javie to klasy z pakietu java.math przeznaczone do pracy z liczbami o bardzo dużej precyzji lub
        wartościami większymi niż te, które mogą być reprezentowane przez standardowe typy liczbowe w Javie, takie jak int, long, float, czy double.

        BigInteger: Klasa do reprezentacji i obliczeń na liczbach całkowitych o dowolnej długości.
        BigDecimal: Klasa do reprezentacji i obliczeń na liczbach zmiennoprzecinkowych z dowolną precyzją.

        Kiedy używa się BigNumbers?

        Gdy wartości liczbowe przekraczają zakres typów wbudowanych.
        - int ma zakres od -2³¹ do 2³¹-1.
        - long ma zakres od -2⁶³ do 2⁶³-1. Jeśli liczba przekracza te zakresy, używamy BigInteger.

        Do obliczeń wymagających dużej precyzji.
        - float i double mogą wprowadzać błędy zaokrągleń podczas operacji.
        - W takich sytuacjach, np. w finansach, używa się BigDecimal, aby uniknąć problemów z dokładnością.
         */

        BigInteger bigNumber1 = new BigInteger("5");
        BigInteger bigNumber2 = BigInteger.valueOf(3085747895L);

        BigInteger sum = bigNumber1.add(bigNumber2);
        BigInteger difference = bigNumber1.subtract(bigNumber2);
        BigInteger product = bigNumber1.multiply(bigNumber2);
        BigInteger quotient = bigNumber1.divide(bigNumber2);
        BigInteger remainder = bigNumber1.mod(bigNumber2);
        BigInteger power = bigNumber1.pow(10);

        System.out.println("---------------- compareTo/equals ---------------- ");
        System.out.println();

        /*
        W Javie, porównywanie wielkich liczb, czyli obiektów klasy BigInteger, odbywa się za pomocą metod dostarczonych
        przez tę klasę. Ponieważ BigInteger nie wspiera bezpośredniego używania operatorów porównania takich
        jak ==, <, >, musisz używać odpowiednich metod instancyjnych, aby porównać dwie liczby.

        Najczęściej używaną metodą do porównywania obiektów BigInteger jest compareTo. Zwraca ona wartość typu int,
        która informuje o relacji między dwiema liczbami:
        - 0 jeśli obie liczby są równe,
        - -1 jeśli pierwsza liczba jest mniejsza od drugiej,
        - 1 jeśli pierwsza liczba jest większa od drugiej.
         */

        BigInteger bigNumber3 = new BigInteger("12345678901234567890");
        BigInteger bigNumber4 = new BigInteger("98765432109876543210");

        int result = bigNumber3.compareTo(bigNumber4);

        if (result == 0) {
            System.out.println("Liczby są równe.");
        } else if (result < 0) {
            System.out.println("bigNumber3 jest mniejsza od bigNumber4.");
        } else {
            System.out.println("bigNumber3 jest większa od bigNumber4.");
        }

        // lub za pomocą equals

        if (bigNumber1.equals(bigNumber2)) {
            System.out.println("Liczby są równe.");
        } else {
            System.out.println("Liczby nie są równe.");
        }

        System.out.println("---------------- Roznice ---------------- ");
        System.out.println();

        /*
        .equals()

        Co robi:
        Metoda sprawdza, czy dwa obiekty są dokładnie takie same (tj. mają tę samą wartość i ten sam typ).
        Porównuje całą reprezentację obiektu, w tym potencjalnie różnice w typie danych, jeśli występują.

        Zastosowanie:
        Używana głównie, gdy chcesz sprawdzić, czy dwie liczby są równe w sensie ich wartości.
         */

        System.out.println("equals");
        BigInteger num1 = new BigInteger("12345");
        BigInteger num2 = new BigInteger("12345");
        BigInteger num3 = new BigInteger("123456");
        BigInteger num5 = BigInteger.valueOf(12345L);

        System.out.println(num1.equals(num2)); // true (num1 i num2 mają tę samą wartość)
        System.out.println(num1.equals(num5)); // true (num1 i num2 mają tę samą wartość)
        System.out.println(num1.equals(num3)); // false (num1 i num3 różnią się wartościami)


        // equals wymaga, aby obiekty były tej samej klasy i miały dokładnie tę samą wartość.
        BigInteger num4 = BigInteger.valueOf(12345); // Tworzenie z long
        Long longValue = 12345L; // Typ Long

        System.out.println(num4.equals(longValue)); // false (różne typy obiektów)


                /*
        compareTo

        Co robi:
        Metoda porównuje dwa obiekty w sposób porządkowy (wg kolejności wartości).

        Zastosowanie:
        Używana, gdy chcesz określić relację porządkową między wartościami.

        Ważna uwaga:
        compareTo porównuje tylko wartości obiektów i ignoruje różnice w typie. Nie ma znaczenia, jak zostały utworzone liczby.
         */

        BigInteger num11 = new BigInteger("12345");
        BigInteger num21 = new BigInteger("12345");
        BigInteger num31 = new BigInteger("123456");

        System.out.println(num11.compareTo(num21)); // 0 (num1 == num2)
        System.out.println(num11.compareTo(num31)); // -1 (num1 < num3)
        System.out.println(num31.compareTo(num11)); // 1 (num3 > num1)

//                System.out.println(num4.compareTo(longValue)); // nie zadziala bo inne obiekty



        /*
        Kiedy używać equals, a kiedy compareTo?

        equals:
        Używaj, gdy chcesz upewnić się, że dwie liczby są identyczne (dokładnie ta sama wartość i ten sam typ).
        Typowe zastosowanie: porównania w kolekcjach (HashSet, HashMap).

        compareTo:
        Używaj, gdy potrzebujesz wiedzieć, która liczba jest większa, mniejsza lub równa w sensie wartości.
        Typowe zastosowanie: sortowanie (TreeSet, TreeMap) lub implementacja algorytmów, które zależą od kolejności liczb.
         */


        System.out.println("---------------- Stałe ---------------- ");
        System.out.println();

        // stale reprezentujace 0,1,2,10
        System.out.println(BigInteger.ZERO);
        System.out.println(BigInteger.ONE);
        System.out.println(BigInteger.TWO);
        System.out.println(BigInteger.TEN);

        // zwraca signum,
        // czyli 1 jesli > 0
        // 0 jesli =0
        // -1 jesli < 0
        System.out.println(bigNumber4.signum());

        BigInteger a = new BigInteger("17");
        BigInteger b = new BigInteger("5");

        // zwraca wieksza z dwoch
        System.out.println("wieksza " + a.max(b));
        // mniejsza z dwoch
        System.out.println("mniejsza " + b.min(a));


        // liczba przeciwna
        System.out.println(a.negate());

        BigDecimal bd = new BigDecimal("-4.543");

        // laczna liczba cyfr
        System.out.println(bd.precision());

        // liczba cyfr na prawo od kropki
        System.out.println(bd.scale());

        // Stworz liste BigItnow, stworz pare obiektow BigInt, dodaj je do listy,
        // wyswietl w kolejnosci rosnacej

        List<BigInteger> bigIntegersList = new ArrayList<>();
        BigInteger bigNumber1Zad1 = new BigInteger("1234");
        BigInteger bigNumber2Zad1 = new BigInteger("12345");
        BigInteger bigNumber3Zad1 = new BigInteger("12346");
        BigInteger bigNumber4Zad1 = new BigInteger("-12346");
        BigInteger bigNumber5Zad1 = new BigInteger("17");

        bigIntegersList.add(bigNumber1Zad1);
        bigIntegersList.add(bigNumber2Zad1);
        bigIntegersList.add(bigNumber3Zad1);
        bigIntegersList.add(bigNumber4Zad1);
        bigIntegersList.add(bigNumber5Zad1);

        List<BigInteger> bigIntegersList2 = new ArrayList<>();
        BigInteger bigNumber1Zad12 = new BigInteger("12334");
        BigInteger bigNumber2Zad12 = new BigInteger("12345");
        BigInteger bigNumber3Zad12 = new BigInteger("12346");
        BigInteger bigNumber4Zad12 = new BigInteger("-12346");
        BigInteger bigNumber5Zad12 = new BigInteger("127");

        bigIntegersList2.add(bigNumber1Zad12);
        bigIntegersList2.add(bigNumber2Zad12);
        bigIntegersList2.add(bigNumber3Zad12);
        bigIntegersList2.add(bigNumber4Zad12);
        bigIntegersList2.add(bigNumber5Zad12);


        Collections.sort(bigIntegersList);
        System.out.println(bigIntegersList);

        BigInteger testZad2 = new BigInteger("12341");

        System.out.println(getBigIntegers(bigIntegersList, testZad2));

        System.out.println(getBiggestInt(bigIntegersList));

        System.out.println(getModuloBigInt(bigIntegersList, 5, 2));

        System.out.println(getCommonBigInts(bigIntegersList, bigIntegersList2));

        List<List<BigInteger>> listOfBigIntsSum = new ArrayList<>();
        listOfBigIntsSum.add(bigIntegersList);
        listOfBigIntsSum.add(bigIntegersList2);


        System.out.println(getSumOfBiggestElements(listOfBigIntsSum));



    }

    //napisz metode ktora przyjmuje jako parametr Liste BigIntow i zwraca Liste
    // liczb wiekszych od podanego parametru

    private static List<BigInteger> getBigIntegers(List<BigInteger> listOfBigInts, BigInteger bigNumber) {
        List<BigInteger> output = new ArrayList<>();

        for (BigInteger bigInt : listOfBigInts) {
            if (bigInt.compareTo(bigNumber) > 0) {
                output.add(bigInt);
            }
        }
        return output;
    }

    // Stwórz metode która znajduje najwieksza liczbe typu BigInt na liscie

    private static BigInteger getBiggestInt(List<BigInteger> listOfBigInts) {
        BigInteger max = listOfBigInts.getFirst();

        for (BigInteger bigInt : listOfBigInts) {
            max = bigInt.max(max);
        }
        return max;
    }

    // Stworz metode ktora przyjmuje jako parametr liste bigitnow oraz dwa inty a i
    // b i zwroci liste wszystkich elementow z listy ktorych wartosc modulo a = b.
    // element listy=17, a = 5, b=2 17mod5 =2

    private static List<BigInteger> getModuloBigInt(List<BigInteger> listOfBigInts, int a, int b) {
        List<BigInteger> output = new ArrayList<>();

        for (BigInteger bigInt : listOfBigInts) {
            if (bigInt.mod(BigInteger.valueOf(a)).equals(BigInteger.valueOf(b))) {
                output.add(bigInt);
            }
        }
        return output;
    }

    //napisz metode która zwroci wspolne elementy z dwoch list wielkich liczb

//    public static Set<BigInteger> getCommonBigInts(List<BigInteger> listOfBigInts1, List<BigInteger> listOfBigInts2) {
//        Set<BigInteger> output = new HashSet<>();
//
//        for (int i = 0; i < listOfBigInts1.size(); i++) {
//            BigInteger tempBigInt = listOfBigInts1.get(i);
//            for (int j = 0; j <listOfBigInts2.size() ; j++) {
//                if(tempBigInt.equals(listOfBigInts2.get(j))){
//                    output.add(tempBigInt);
//                }
//            }
//        }
//        return output;
//    }

    private static Set<BigInteger> getCommonBigInts(List<BigInteger> listOfBigInts1, List<BigInteger> listOfBigInts2) {
        Set<BigInteger> output = new HashSet<>();

        for (BigInteger bigInt:listOfBigInts1){
            if(listOfBigInts2.contains(bigInt)){
                output.add(bigInt);
            }
        }
        return output;
    }

    // Stworz metode ktora przyjmuje jako parametr liste list big intow :). Z kazdej
    // listy znajdz najwieksza wartosc i oblicz sume najwiekszych wartosci.

    private static BigInteger getSumOfBiggestElements(List<List<BigInteger>> listOfBigInts){
        BigInteger sum = BigInteger.ZERO;

        for (int i = 0; i <listOfBigInts.size() ; i++) {
            BigInteger temp = Collections.max(listOfBigInts.get(i));
            sum = sum.add(temp);
        }

        return sum;
    }
}
