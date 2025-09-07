package basics.o15.enumy.dzialania;

public enum DoubleCount {
    SUM {
        @Override
        public double count(double num1, double num2) {
            return num1 + num2;
        }
    },
    SUBTRACTION {
        @Override
        public double count(double num1, double num2) {
            return num1 - num2;
        }
    },
    MULTIPLY {
        @Override
        public double count(double num1, double num2) {
            return num1 * num2;
        }
    },
    DIVIDE {
        @Override
        public double count(double num1, double num2) {
            return num1 / num2;
        }
    };

    public abstract double count(double num1, double num2);
}
