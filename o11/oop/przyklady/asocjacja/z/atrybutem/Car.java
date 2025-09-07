package basics.o11.oop.przyklady.asocjacja.z.atrybutem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Car {


    private String brand;

    private List<CarRepair> repairs = new ArrayList<>();

    public Car(String brand) {
        this.brand = brand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(brand, car.brand) && Objects.equals(repairs, car.repairs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, repairs);
    }

    public void addRepair(CarRepair carRepair){
        if (!repairs.contains(carRepair)){
            repairs.add(carRepair);
        }
    }

    public String getBrand() {
        return brand;
    }

    public List<CarRepair> getRepairs() {
        return repairs;
    }

}
