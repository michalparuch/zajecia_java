package basics.o15.enumy.dzialania;

public class Main {
    public static void main(String[] args) {
        double num1 = 20;
        double num2 = 10;

        System.out.println(DoubleCount.DIVIDE.count(num2, num1));
        System.out.println(DoubleCount.SUM.count(num2, num1));
        System.out.println(DoubleCount.SUBTRACTION.count(num2, num1));
        System.out.println(DoubleCount.MULTIPLY.count(num2, num1));
    }

    // Napisz kalkulator opierajacy sie o typ wyliczeniowy i metode abstrakcyjna double count(double d1, double d2)


}
