package basics.o11.oop.projekt_uml;

public class Truck extends Vehicle{
    private double capacity;

    public Truck(String brand, Integer productionYear, String model, String octane, double capacity) {
        super(brand, productionYear, model, octane);
        this.capacity = capacity;
    }

    public Truck(String brand, String model, Integer productionYear, String dpfBrand, double capacity) {
        super(brand, model, productionYear, dpfBrand);
        this.capacity = capacity;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

}

