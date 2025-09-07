package basics.o11.oop.projekt_uml;
import java.util.ArrayList;
import java.util.List;

public class Car extends Vehicle {
    private double accelerationTo100;
    private List<CarPart> parts = new ArrayList<>();
    private List<Driver> driversList = new ArrayList<>();


    public Car(String brand, Integer productionYear, String model, String octane, double accelerationTo100) {
        super(brand, productionYear, model, octane);
        this.accelerationTo100 = accelerationTo100;
    }

    public Car(String brand, String model, Integer productionYear, String dpfBrand, double accelerationTo100) {
        super(brand, model, productionYear, dpfBrand);
        this.accelerationTo100 = accelerationTo100;
    }

    public double getAccelerationTo100() {
        return accelerationTo100;
    }

    public List<CarPart> getParts() {
        return parts;
    }

    public void setAccelerationTo100(double accelerationTo100) {
        this.accelerationTo100 = accelerationTo100;
    }

    public void setParts(List<CarPart> parts) {
        this.parts = parts;
    }

    public List<Driver> getDriversList() {
        return driversList;
    }

}
