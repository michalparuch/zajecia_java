package basics.o14.bignumbers.bank;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Transaction {
    public static Integer counter = 0;
    private Integer iD;
    private Account account;
    private LocalDateTime timeOfTransaction;
    private String typeOfTransaction;
    private BigDecimal amount;
    private BigDecimal balanceAfterTransaction;

    public Transaction(Account account, LocalDateTime timeOfTransaction, String typeOfTransaction, BigDecimal amount) {
        this.iD = ++counter;
        this.account = account;
        this.timeOfTransaction = timeOfTransaction;
        this.typeOfTransaction = typeOfTransaction;
        this.amount = amount;
        this.balanceAfterTransaction = account.getBalance();
    }

    public static Integer getCounter() {
        return counter;
    }

    public Integer getiD() {
        return iD;
    }

    public Account getAccount() {
        return account;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDateTime getTimeOfTransaction() {
        return timeOfTransaction;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "iD=" + iD +
                ", account=" + account +
                ", timeOfTransaction=" + timeOfTransaction +
                ", typeOfTransaction='" + typeOfTransaction + '\'' +
                ", amount=" + amount +
                ", balanceAfterTransaction=" + balanceAfterTransaction +
                '}';
    }
}
