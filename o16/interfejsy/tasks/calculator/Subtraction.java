package basics.o16.interfejsy.tasks.calculator;

public class Subtraction implements Calculator {
    @Override
    public void calculate(double d1, double d2) {
        System.out.println(d1 - d2);
    }
}
