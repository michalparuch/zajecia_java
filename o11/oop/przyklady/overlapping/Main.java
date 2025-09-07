package basics.o11.oop.przyklady.overlapping;

public class Main {
    public static void main(String[] args) {

        // klasa Training
        // w srodku klasy enum z typami treningu,
        //pola: name, description, style, minimumTimeUnderWater
        // EnumSet<Subclass> gdzie domyslnie dajemy Subclass.Training

        // 3 konstruktory:
        // pierwszy ustawia name, description, style oraz do enumseta dodajemy Subclass.TECHNICAL_TRANING
        // drugi ustawia name, description, minimumTimeUnderWater oraz do enumseta dodajemy Subclass.DIVING_TRANING
        // trzeci ustawia name, description, style,  minimumTimeUnderWater oraz do enumseta dodajemy Subclass.DIVING_TRANING oraz Subclass.TECHNICAL_TRANING

        // oprocz konstuktorow zrob toSTring, ktory zaleznie od zawartosci enumSeta bedzie nam mowil o tym, z jakim treningiem mamy do czynienia


        Training t1 = new Training("Test", "Basic training", "test");
        Training t2 = new Training("Test", "Diving training", 30);
        Training t3 = new Training("Test", "Advance training", "test", 45);

        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);


    }
}
