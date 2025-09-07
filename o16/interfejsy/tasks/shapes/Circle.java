package basics.o16.interfejsy.tasks.shapes;

public class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public Double countArea() {
        return Math.pow(radius, 2) * 3.14;
    }

    @Override
    public Double countCircumference() {
        return 2.0 * 3.14 * radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }
}
