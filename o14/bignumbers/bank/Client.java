package basics.o14.bignumbers.bank;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static Integer counter = 0;
    private Integer iD;
    private String name, surname;
    private List<Account> clientAccounts;

    public Client(String name, String surname) {
        this.iD = ++counter;
        this.name = name;
        this.surname = surname;
        this.clientAccounts = new ArrayList<>();
    }

    public Integer getiD() {
        return iD;
    }

    public String getName() {
        return name;
    }

    public List<Account> getClientAccounts() {
        return clientAccounts;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Client{" +
                "iD=" + iD +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
