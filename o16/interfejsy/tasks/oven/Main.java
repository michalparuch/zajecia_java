package basics.o16.interfejsy.tasks.oven;

public class Main {
    public static void main(String[] args) {

        //Stworz klase Piekarnik (czas, temperatura). Piekarnik ma rozne ustawienia fabryczne, np do pieczenia mies i ciast, ale dla pieczenia mies ma
        //inne ustawienia w przypadku np drobiu, a inne w przypadku wolowiny i podobnie jest z pieczeniem ciast, chleba itd

        // piekarnik nie musi miec konstruktora (wystarczy domyslny)
        // pola ustawiamy na konkretne wartosci w implementacji metod z interfejsow
        // interfejsy robimy osobno dla mies, osobno dla ciast i tam rozne metody dla roznych pieczonych żarć

        // zrob metode static startBaking() gdzie wydrukuejsz println info co sie piecze, jak dlugo i w jakiej temperaturze. te metode wywolasz potem w implementacji kazdej z metod abstrakcyjnych

        Oven oven = new Oven();

        oven.bakeBeef("10", 200);
        oven.bakeBread("10", 150);
        oven.bakeCake("10", 250);
        oven.bakeChicken("10", 200);

    }
}
