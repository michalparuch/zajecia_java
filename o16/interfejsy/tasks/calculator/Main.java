package basics.o16.interfejsy.tasks.calculator;

public class Main {

    // stworz interfejs Calculator z metod double calculate(double d1, double d2) i implementuj go w 4 klasach wykonujacych podstawowe obliczenia matematyczne
    public static void main(String[] args) {

        Multiply multiply = new Multiply();
        Subtraction subtraction = new Subtraction();
        Sum sum = new Sum();
        Divide divide = new Divide();

        multiply.calculate(1.0, 2.0);
        subtraction.calculate(1.0, 2.0);
        sum.calculate(1.0, 2.0);
        divide.calculate(1.0, 2.0);
    }
}
