package basics.o11.oop.basics;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Car {

    private static List<Car> extention = new ArrayList<>();

    //atrybut klasowy - ma taka sama wartosc dla kazdego obiektu danej klasy, UML nazwaAtrubutu podkreslona
    private static final int numberOfWheels = 4;

    //atrybuty klasy Car

    private String brand;
    private String model;
    private int productionYear; //atrybut prosty, nie ma zadnych dodatkowych warunkow, wymagan
    private String trim; //atrybut opcjonalny, moze miec wartosc, moze nie miec UML nazwaAtrbutu[0..1]

    //atrybut powtarzalny, to taki atrybut ktory moze miec wiecej niz jedna wartosc
    private List<String> equipmentList = new ArrayList<>();

    //atrybut unikalny - omowimy pozniej (w temacie ekstencji)

    //Atrybut zlozony, jest to atrybut ktory jest opisany za pomoca innej klasy
    private Engine engine;

    //atrybut wyliczalny - atrybut ktory jest zaimplementowany za pomoca metody, nie trzeba robic pola tego atrubutu
    //UML /nazwaAtrybutu
    private Integer value;
    private String color;
    private Integer millage;

    //konstruktor klasy Car, uruchamiany w momencie tworzenia obiektu, za pomoca slowa kluczowego new
    //nic nie zwracaja, nie deklaruja typu zwracanego, nazwa identyczna jak nazwa klasy
    //konstruktor wymusza odpowiednia budowe obiektu
    //przeciazenie konstruktorow tylko dla atrubutow opcjonalnych
    public Car(String brand, String model, int productionYear, String trim, Engine engine, Integer value, String color, Integer millage) {
        this.brand = brand;
        this.model = model;
        this.productionYear = productionYear;
        this.trim = trim;
        this.engine = engine;
        this.value = value;
        this.color = color;
        this.millage = millage;
        extention.add(this);
    }

    public Car(String brand, String model, int productionYear, Engine engine, Integer value, String color, Integer millage) {
        this.brand = brand;
        this.model = model;
        this.productionYear = productionYear;
        this.engine = engine;
        this.value = value;
        this.color = color;
        this.millage = millage;
        extention.add(this);
    }

    // pusty konstruktor bez parametrow, pola ustawiamy setterami lub metodami
    public Car() {
        extention.add(this);
    }

    //metody do atrybutu powtarzalnego
    public void addEquipment(String equipment) {
        if (!equipmentList.contains(equipment)) {
            equipmentList.add(equipment);
        }
    }

    public void removeEquipment(String equipment) {
        if (equipmentList.contains(equipment)) {
            equipmentList.remove(equipment);
        }
    }

    public List<String> returnEquipments() {
        return equipmentList;
    }

    //metoda dla atrybutu wyliczalnego
    public boolean emissionTestPassed() {
        if (productionYear > 2010) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return brand + " " + model;
    }

        /*
    Metoda equals() jest używana do sprawdzania równości dwóch obiektów. Domyślna implementacja tej
    metody w klasie Object sprawdza, czy referencje obu obiektów są takie same, co oznacza, że
    dwa różne obiekty (o różnych adresach w pamięci) zawsze będą uznawane za różne, nawet jeśli mają takie same wartości pól.
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return productionYear == car.productionYear && Objects.equals(brand, car.brand) && Objects.equals(model, car.model) && Objects.equals(trim, car.trim) && Objects.equals(equipmentList, car.equipmentList) && Objects.equals(engine, car.engine);
    }

        /*
    Metoda hashCode() zwraca wartość liczbową zwaną kodem haszującym, która reprezentuje dany obiekt w formie liczbowej.
    Kod haszujący jest wykorzystywany w strukturach danych takich jak HashMap czy HashSet do organizacji i szybkiego wyszukiwania elementów.
     */

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, productionYear, trim, equipmentList, engine);
    }

    /*
    Jeżeli nadpisujemy metodę equals(), powinniśmy także nadpisać metodę hashCode().
    Wynika to z kontraktu między equals() a hashCode(), który mówi:

        - Jeżeli dwa obiekty są równe zgodnie z equals(), to ich kody haszujące muszą być takie same.
        - Jednakże, obiekty o tym samym kodzie haszującym nie muszą być równe (może się zdarzyć, że
          różne obiekty przypadkiem mają ten sam kod haszujący).
     */

    //gettery i setter to metody ktore sluza do zwrocenia danego atrybutu oraz do ustawienia nowej wartosci atrybutu


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public String getTrim() {
        return trim;
    }

    public void setTrim(String trim) {
        this.trim = trim;
    }

    public List<String> getEquipmentList() {
        return equipmentList;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public static List<Car> getExtention() {
        return extention;
    }

    public String getColor() {
        return color;
    }

    public Integer getMillage() {
        return millage;
    }

    // napisz metode obliczajaca wiek auta

    public Integer getCarAge() {
        return 2025 - this.productionYear;
    }

    // napisz metode ktora znajduje wszystkie auta marki bmw

    public static List<Car> getAllBMW() {
        List<Car> bmwCar = new ArrayList<>();

        for (Car entry : extention) {
            if (entry.brand.equals("BMW")) {
                bmwCar.add(entry);
            }
        }
        return bmwCar;
    }

    // TODO domowe:
    // napisz metode ktora sumuje ceny wszystkich aut
    public Integer getValue() {
        return value;
    }

    public static Integer getValueOfAllCars() {
        Integer sum = 0;
        for (Car car : extention) {
            sum += car.getValue();
        }
        return sum;
    }

    // napisz metode ktora zwraca nazwy wszystkich marek (unikalnych!)
    public static List<String> getAllCarBrands() {
        List<String> allBrands = new ArrayList<>();

        for (Car car : extention) {
            String brand = car.getBrand();
            if (!allBrands.contains(brand)) {
                allBrands.add(brand);
            }
        }
        return allBrands;
    }

    // napisz metode ktora znajduje auto o najnizszym przebiegu
    public static Car getCarWithLowestValue() {
        Car lowestValueCar = null;
        for (Car car : extention) {
            Integer value = car.getValue();
            if (lowestValueCar== null || lowestValueCar.getValue() > value) {
                lowestValueCar = car;
            }
        }
        return lowestValueCar;
    }

    // napisz metode ktora znajduje wszystkie auta o kolorze niebieskim starsze niz 15 lat
    public static List<Car> getBlueCarsOlderThan15() {
        List<Car> blueCarsOlderThan15 = new ArrayList<>();

        for (Car car : extention) {
            if (car.getCarAge() > 15 && car.getColor().equalsIgnoreCase("blue")) {
                blueCarsOlderThan15.add(car);
            }
        }
        return blueCarsOlderThan15;
    }

    // napisz metode ktora znajduje najdrozsze auto ale z aut z przebiegiem mniejszym nzi 30k
    public static Car getMostExpensiveCarWithLessThan30k() {
        Car mostExpensiveCar = null;

        for (Car car : extention) {
            if (car.getMillage() < 30000) {
                if (mostExpensiveCar == null || car.getValue() > mostExpensiveCar.getValue()) {
                    mostExpensiveCar = car;
                }
            }
        }
        return mostExpensiveCar;
    }

    // znajdz najtansze auto marki bmw
    public static Car getCheapestBMW() {
        Car cheapestCar = null;

        for (Car car : extention) {
            if (car.getBrand().equalsIgnoreCase("bmw")) {
                if (cheapestCar == null || car.getValue() < cheapestCar.getValue()) {
                    cheapestCar = car;
                }
            }
        }
        return cheapestCar;
    }

    // znajsz wszystkie auta ktore w marce maja literke a
    public static List<Car> getAllCarsWithLetterA() {
        List<Car> carsWithLetterA = new ArrayList<>();

        for (Car car : extention) {
            if (car.getBrand().toLowerCase().contains("a")) {
                carsWithLetterA.add(car);
            }
        }
        return carsWithLetterA;
    }

    // znajdz najdrozsze auto ktorego marka ma dlugosc wieksza niz 4
    public static Car getMostExpensiveCarWithLetterA() {
        Car mostExpensiveCar = null;

        for (Car car : extention) {
            if (car.getBrand().length() > 4) {
                if (mostExpensiveCar == null || car.getValue() > mostExpensiveCar.getValue()) {
                    mostExpensiveCar = car;
                }
            }

        }
        return mostExpensiveCar;
    }

}
