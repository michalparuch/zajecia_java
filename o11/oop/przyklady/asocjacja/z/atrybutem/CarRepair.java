package basics.o11.oop.przyklady.asocjacja.z.atrybutem;

public class CarRepair {

    private String date;
    private double price;
    private Car car;
    private Garage garage;

    public CarRepair(String date, double price, Car car, Garage garage) {
        this.date = date;
        this.price = price;
        this.car = car;
        car.addRepair(this);
        this.garage = garage;
        garage.addRepair(this);
    }

    @Override
    public String toString() {
        return "CarRepair{" +
                "date='" + date + '\'' +
                ", price=" + price +
                ", car=" + car.getBrand() +
                ", garage=" + garage.getName() +
                '}';
    }

}
