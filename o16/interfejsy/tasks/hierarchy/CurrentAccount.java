package basics.o16.interfejsy.tasks.hierarchy;

import java.math.BigInteger;
import java.util.Random;

public class CurrentAccount implements Transferable {
    Client client;
    String accountNumber;
    Double balance;

    public CurrentAccount(Client client, Double balance) {
        this.client = client;
        this.accountNumber = generateAccountNumber();
        this.balance = balance;
        client.setCurrentAccount(this);
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
    public void transfer(Double amount, Depositable account) {
        if (validateBalance(amount)) {
            balance = balance - amount;
            account.deposit(amount);
        }
    }

    @Override
    public void deposit(Double amount) {
        balance = balance + amount;
    }

    public String generateAccountNumber() {
        StringBuilder sb = new StringBuilder();
        sb.append("PL");

        for (int i = 0; i < 26; i++) {
            sb.append(new Random().nextInt(10));
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "CurrentAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                '}';
    }
}
