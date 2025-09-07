package basics.o11.oop.basics;

public class Main {
    public static void main(String[] args) {

        // Obiekt - wystąpienie (instancja) klasy, konkretny byt

        // Klasa - naturalny opis obiektu, zawiera zestaw cech i metod dla danego
        // obiektu

        // Ekstensja klasy - zbiór wszystkich obiektów danej klasy // tu nam pomoze, ale nie dawac na testach do waldka

        Car car = new Car("Toyota","Supra",2023,"Premium", new Engine(2993), 300000, "red", 40000);
        Car car2 = new Car("BMW","Z4",2023, new Engine(2993), 250000, "blue", 5000);
        Car car3 = new Car("BMW","Z3",2009, new Engine(2993), 350000, "blue", 50000);
        Car car4 = new Car("Toyota","Tundra",2023,"Premium", new Engine(2993), 800000, "red", 40000);
        Car car5 = new Car("Acura","Tundra",2023,"Premium", new Engine(2993), 100000, "red", 4000);
//        Car car3 = new Car();

        System.out.println(car);

        System.out.println(car.equals(car2));

        System.out.println(Car.getExtention());
        System.out.println(car2);
        System.out.println(car.getCarAge());
        System.out.println(Car.getAllBMW());
        System.out.println(Car.getAllCarBrands());


        System.out.println("---------Zadania Domowe---------");

        System.out.println(Car.getValueOfAllCars());
        System.out.println(Car.getAllCarBrands());
        System.out.println(Car.getCarWithLowestValue());
        System.out.println(Car.getBlueCarsOlderThan15());
        System.out.println(Car.getMostExpensiveCarWithLessThan30k());
        System.out.println(Car.getCheapestBMW());
        System.out.println(Car.getAllCarsWithLetterA());
        System.out.println(Car.getMostExpensiveCarWithLetterA());

    }
}
