package basics.o16.interfejsy.tasks.hierarchy;

public interface Withdrawable extends Account{

    void withdraw(Double amount);

    default boolean validateBalance(double amount) {
        return getBalance() >= amount;
    }

    default void quickWithdraw(){
        withdraw(50.00);
    }

}
