package basics.o16.interfejsy.tasks.shapes;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // stworz Kwadrat (bok), Kolo (promien), Prostokat (dl,szer)
        // - znajdz figure z najwieskszym polem
        // - znajdz figure z najwiekszym obwodem
        // - zwroc liste wszystkich figur które maja pole wieksze niz 30cm^2
        // - zwróc liste koł ktore maja promien mniejszy niz 7cm


        Circle circle = new Circle(3.0);
        Square square = new Square(5.0);
        Rectangle rectangle = new Rectangle(3.0, 2.0);

        System.out.println(Shape.getFigureWithLargestArea(Arrays.asList(circle, square, rectangle)));
        System.out.println(Shape.getFigureWithLargestCircumference(Arrays.asList(circle, square, rectangle)));

        System.out.println("Obwód kola " + circle.countCircumference());
        System.out.println("Obwód kwadratu " + square.countCircumference());
        System.out.println("Obwód prostokatu " + rectangle.countCircumference());

        System.out.println("Pole kola " + circle.countArea());
        System.out.println("Pole kwadratu " + square.countArea());
        System.out.println("Pole prostokatu " + rectangle.countArea());


    }
}
