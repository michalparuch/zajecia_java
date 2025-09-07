package basics.o15.enumy.koszule;

public class Shirt {

    private String brand;
    private String color;
    private ShirtSize size;

    public Shirt(String brand, String color, ShirtSize size) {
        this.brand = brand;
        this.color = color;
        this.size = size;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ShirtSize getSize() {
        return size;
    }

    public void setSize(ShirtSize size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Shirt{" +
                "brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", size=" + size +
                '}';
    }
}
