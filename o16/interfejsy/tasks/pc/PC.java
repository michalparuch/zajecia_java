package basics.o16.interfejsy.tasks.pc;

public class PC {
    private String brand;
    private Double price;
    private HardDrive hardDrive;

    public PC(String brand, Double price, HardDrive hardDrive) {
        this.brand = brand;
        this.price = price;
        this.hardDrive = hardDrive;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public HardDrive getHardDrive() {
        return hardDrive;
    }

    public void setHardDrive(HardDrive hardDrive) {
        this.hardDrive = hardDrive;
    }

    @Override
    public String toString() {
        return "PC{" +
                "price=" + price +
                ", brand='" + brand + '\'' +
                '}';
    }
}
