package basics.o16.interfejsy;

public class MethodParameter {

    public static void drawShape(Shape shape) {
        shape.draw();
    }

    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape rectangle = new Rectangle();

        drawShape(circle);    // Rysowanie koła
        drawShape(rectangle); // Rysowanie prostokąta
    }
}

interface Shape {
    void draw();
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Rysowanie koła");
    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Rysowanie prostokąta");
    }
}
