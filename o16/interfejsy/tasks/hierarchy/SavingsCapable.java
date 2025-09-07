package basics.o16.interfejsy.tasks.hierarchy;

interface SavingsCapable extends Depositable, Withdrawable {
    double getInterestRate();

    default double calculateInterest() {
        return getBalance() * getInterestRate();
    }

    default void capitalizeInterest() {
        double interest = calculateInterest();
        if (interest > 0) {
            deposit(interest);
            System.out.println("Amount of interests: " + interest + " PLN has been added to account " + getAccountNumber());
        }
    }

    static double simulateInterest(double amount, double rate, int months) {
        return amount * rate * (months / 12.0);
    }
}
