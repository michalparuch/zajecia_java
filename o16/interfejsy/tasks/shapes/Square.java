package basics.o16.interfejsy.tasks.shapes;

public class Square implements Shape {
    private double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public Double countCircumference() {
        return Math.pow(sideLength, 2);
    }

    @Override
    public Double countArea() {
        return sideLength * 4;
    }

    @Override
    public String toString() {
        return "Square{" +
                "sideLength=" + sideLength +
                '}';
    }
}
