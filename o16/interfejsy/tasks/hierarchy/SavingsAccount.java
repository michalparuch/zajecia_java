package basics.o16.interfejsy.tasks.hierarchy;

public class SavingsAccount implements SavingsCapable {
    Client client;
    String accountNumber;
    Double balance;
    Double interestRate;

    public SavingsAccount(Client client, Double interestRate) {
        this.client = client;
        this.interestRate = interestRate;
        this.accountNumber = client.getCurrentAccount().getAccountNumber();
        this.balance = 0.00;

        client.addSavingsAccount(this);
    }

    @Override
    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public void withdraw(Double amount) {
        if (validateBalance(amount)) {
            balance = balance - amount;
        } else {
            throw new IllegalArgumentException("Not enough balance!");
        }
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public Double getBalance() {
        return balance;
    }


    @Override
    public void deposit(Double amount) {
        balance = balance + amount;
    }
}
