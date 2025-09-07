package basics.o11.oop.przyklady.dziedziczenie.wieloaspektowe;

public class Car extends Vehicle {

    private double topSpeed;

    public Car(String model, String brand, String typeOfDpf, int productionYear, double topSpeed) {
        super(model, brand, typeOfDpf, productionYear);
        this.topSpeed = topSpeed;
    }

    public Car(String model, String brand, int productionYear, int octaneNumber, double topSpeed) {
        super(model, brand, productionYear, octaneNumber);
        this.topSpeed = topSpeed;
    }

}
