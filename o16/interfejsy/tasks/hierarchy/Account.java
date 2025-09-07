package basics.o16.interfejsy.tasks.hierarchy;

import java.util.regex.Pattern;

public interface Account {
    String getAccountNumber();
    Double getBalance();

    default void printBalance() {
        System.out.println("Account balance " + getAccountNumber() + ": " + getBalance() + " PLN");
    }

    static boolean validateAccountNumber(String number){
        Pattern pattern = Pattern.compile("PL\\d{26}");
        if (number == null) return false;
        return pattern.matcher(number).matches();
    }
}
