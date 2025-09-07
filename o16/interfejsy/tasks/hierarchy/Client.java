package basics.o16.interfejsy.tasks.hierarchy;

import java.util.ArrayList;
import java.util.List;

public class Client extends AbstractClient {
    private CurrentAccount currentAccount;
    private List<SavingsAccount> savingsAccountList;

    public Client(String surname, String name) {
        super(surname, name);
        this.currentAccount = null;
        this.savingsAccountList = new ArrayList<>();
    }

    public CurrentAccount getCurrentAccount() {
        return currentAccount;
    }

    public void addSavingsAccount(SavingsAccount savingsAccount) {
        savingsAccountList.add(savingsAccount);
    }

    public void setCurrentAccount(CurrentAccount currentAccount) {
        this.currentAccount = currentAccount;
    }
}
