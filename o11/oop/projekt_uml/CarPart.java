package basics.o11.oop.projekt_uml;

public class CarPart {
    private String name;
    private Car car;

    public CarPart(String name, Car car) {
        this.name = name;
        this.car = car;
        addCarPart(car);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addCarPart(Car car){
        car.getParts().add(this);
    }
}
