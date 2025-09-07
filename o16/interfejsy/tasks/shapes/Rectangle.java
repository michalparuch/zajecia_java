package basics.o16.interfejsy.tasks.shapes;

public class Rectangle implements Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public Double countArea() {
        return length * width;
    }

    @Override
    public Double countCircumference() {
        return length * 2 + width * 2;
    }

    @Override
    public String toString() {
        return "Recktangle{" +
                "length=" + length +
                ", width=" + width +
                '}';
    }
}
