package basics.o15.enumy.metodyabstr;

public class Car {

    private String brand;
    private CarEnum carEnum;

    public Car(String brand, CarEnum carEnum) {
        this.brand = brand;
        this.carEnum = carEnum;
    }

    public String getBrand() {
        return brand;
    }

    public CarEnum getCarEnum() {
        return carEnum;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setCarEnum(CarEnum carEnum) {
        this.carEnum = carEnum;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                '}';
    }
}
