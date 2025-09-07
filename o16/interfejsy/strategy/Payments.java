package basics.o16.interfejsy.strategy;

public class Payments {

    // Strategia (wzorzec projektowy): Interfejsy umożliwiają dynamiczne zmienianie zachowania.

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.setPaymentStrategy(new CreditCardPayment());
        cart.checkout(100);

        cart.setPaymentStrategy(new PayPalPayment());
        cart.checkout(200);
    }

}

interface PaymentStrategy {

    void pay(int amount);

}

class CreditCardPayment implements PaymentStrategy {

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
    }

}

class PayPalPayment implements PaymentStrategy {

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using PayPal.");
    }

}

class ShoppingCart {

    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount) {
        paymentStrategy.pay(amount);
    }

}
