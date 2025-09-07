package basics.o14.bignumbers.bank;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class Account {
    //BigDecimal
    public static List<Account> extension = new ArrayList<>();
    public static Set<BigInteger> setOfAccountNumbers = new HashSet<>();

    private Client client;
    private BigInteger accountNumber;
    private BigDecimal balance;
    private List<Transaction> transactionsList;

    public Account(Client client) {
        this.client = client;
        this.accountNumber = generateAccountNumber();
        this.transactionsList = new ArrayList<>();
        this.balance = BigDecimal.ZERO;

        assignAccountToClient(client);
        extension.add(this);
    }

    public Client getClient() {
        return client;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public List<Transaction> getTransactionsList() {
        return transactionsList;
    }

    public BigInteger generateAccountNumber() {

        // ciekawostka, unikalne id:
        String uniqueId = UUID.randomUUID().toString();

        Random random = new Random();
        BigInteger accountNumber = null;

        boolean isUnique = false;

        while (!isUnique) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append(random.nextInt(10));
            }
            accountNumber = new BigInteger(sb.toString());

            if (!setOfAccountNumbers.contains(accountNumber)) {
                setOfAccountNumbers.add(accountNumber);
                isUnique = true;
            }
        }

        return accountNumber;

    }

    public void assignAccountToClient(Client client) {
        client.getClientAccounts().add(this);
    }

    public void depositBalance(BigDecimal amount) {
        balance = balance.add(amount);
        Transaction transaction = new Transaction(this, LocalDateTime.now(), "Deposit", amount);
        transactionsList.add(transaction);
    }

    public void withdrawBalance(BigDecimal amount) {
//        if (amount.compareTo(balance) > 0) {
//            throw new IllegalArgumentException("You don't have enough balance!");
//        } else {
//            balance = balance.subtract(amount);
//            Transaction transaction = new Transaction(this, LocalDateTime.now(), amount);
//            transactionsList.add(transaction);
//        }

        balance = balance.subtract(amount);
        Transaction transaction = new Transaction(this, LocalDateTime.now(), "Withdrawal", amount);
        transactionsList.add(transaction);

    }

    public void calculateInterests() {
        switch (balance.signum()) {
            case 1, -1:
                balance = balance.add(balance.multiply(BigDecimal.valueOf(0.1)));
                break;

            default:
                break;
        }
    }

    public Account getAccountWithMostBalance() {
        Account accWithMostBalance = extension.getFirst();

        for (Account acc : extension) {
            if (accWithMostBalance.getBalance().compareTo(acc.getBalance()) < 0) {
                accWithMostBalance = acc;
            }
        }
        return accWithMostBalance;
    }

    public Account getAccountWithMostTransactions() {
        Account accWithMostTransactions = extension.getFirst();

        for (Account acc : extension) {
            if (acc.getTransactionsList().size() > accWithMostTransactions.getTransactionsList().size()) {
                accWithMostTransactions = acc;
            }
        }
        return accWithMostTransactions;
    }

    public List<Account> getAccountsWithNegativeBalance() {
        List<Account> listOfAccWithNegativeBalance = new ArrayList<>();

        for (Account acc : extension) {
            if (acc.balance.signum() == -1) {
                listOfAccWithNegativeBalance.add(acc);
            }
        }
        return listOfAccWithNegativeBalance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", balance=" + balance +
                '}';
    }
}



