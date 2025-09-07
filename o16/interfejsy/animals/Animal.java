package basics.o16.interfejsy.animals;

public interface Animal {

    // stała wartosc
    // Do stałych wartosci mozemy przypisac wylacznie raz i podczas inicjalizacji klasy.
    // Zgodnie z konwencja nazewnicza stałe piszemy wielkimi literami.

    // Domyslnie wszystkie atrybuty interfejsu sa stalymi publicznymi przypisanymi do interfejsu
    // wiec slowa kluczowe public static final moga zostac pominiete.
    int NUMBER_OF_PAWS = 4;

    void makeSound();
    void sleep();

}
