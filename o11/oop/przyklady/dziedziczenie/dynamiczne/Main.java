package basics.o11.oop.przyklady.dziedziczenie.dynamiczne;

import java.util.ArrayList;
import java.util.List;

public class Main     {

public static void main(String[] args) {

    // Typ referencji Animal, typ rzeczywisty Dog
    Animal zwierze1 = new Dog(); // Dziedziczenie dynamiczne
    Animal zwierze2 = new Cat(); // Dziedziczenie dynamiczne

    zwierze1.makeNoise(); // Wywołuje metodę z klasy Pies, typ rzeczywisty decyduje jak wygląda metoda
    zwierze2.makeNoise(); // Wywołuje metodę z klasy Kot

    List<Animal> animals = new ArrayList<>();
    animals.add(zwierze1);
    animals.add(zwierze2);
    for (Animal animal : animals) {
        animal.makeNoise();
    }

        /*
        Klasa abstrakcyjna w Javie to specjalny rodzaj klasy, który służy jako szablon dla innych klas.
        Jest ona używana do definiowania wspólnych cech (atrybutów i metod) dla grupy powiązanych klas,
        ale nie można utworzyć jej obiektu bezpośrednio. Klasa abstrakcyjna pozwala na definiowanie
        metod abstrakcyjnych (bez implementacji) oraz metod z implementacją.
         */

        /*
        - Typ referencji (Zwierze) jest określany w czasie kompilacji.
        - Rzeczywisty typ obiektu (Pies, Kot) jest określany w czasie wykonania.
        - Podczas wywołania metody dzwiek(), JVM sprawdza rzeczywisty typ obiektu (np. Pies lub Kot) i
            wywołuje odpowiednią implementację tej metody.
         */

        /*
        Polimorfizm:
        Pozwala pisać bardziej elastyczny kod, który działa na poziomie ogólnej klasy bazowej, ale obsługuje różne
        implementacje w klasach pochodnych.

        Overriding metod:
        Aby dziedziczenie dynamiczne działało, metody w klasach pochodnych muszą nadpisywać (override) metody z klasy bazowej.
         */

}
}

