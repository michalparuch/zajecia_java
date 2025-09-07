package basics.o16.interfejsy.tasks.hierarchy;

public class Main {
    public static void main(String[] args) {

        /*
         * Stworz hieararchie dziedziczenia interfejsow tak aby mialy biznesowy sens. Stworz sensowne biznesowe klasy ktore moga je implementowac
         * (niekoniecznie kazda klasa kazdy interfejs). Niech interefejsy maja rozne metody statyczne, defaultowe, abstrakcyjne, tak aby calosc
         * tworzyła wspolna sensowna całosc :)
         */

        Client client1 = new Client("Kowalski_1", "Jan");
        Client client2= new Client("Kowalski_2", "Jan");

        CurrentAccount currentAccount1 = new CurrentAccount(client1, 0.00);
        CurrentAccount currentAccount2 = new CurrentAccount(client2, 0.00);

        System.out.println(currentAccount1.getBalance());
        System.out.println(currentAccount2.getBalance());

        currentAccount1.deposit(1000.00);
        currentAccount2.deposit(2000.00);

        System.out.println(currentAccount1.getBalance());
        System.out.println(currentAccount2.getBalance());

        //currentAccount1.withdraw(10000.00);
        currentAccount1.withdraw(500.00);
        //System.out.println(currentAccount1.getBalance());

        currentAccount2.transfer(750.00, currentAccount1);
        System.out.println(currentAccount1.getBalance());
        System.out.println(currentAccount2.getBalance());

        SavingsAccount savingsAccount1 = new SavingsAccount(client1, 0.10);
        System.out.println(savingsAccount1.getBalance());
        savingsAccount1.deposit(1000.00);
        System.out.println(savingsAccount1.getBalance());
        savingsAccount1.capitalizeInterest();
        System.out.println(savingsAccount1.getBalance());

        System.out.println(SavingsCapable.simulateInterest(1000.00, 10.00, 12));

        System.out.println(Account.validateAccountNumber(currentAccount1.getAccountNumber()));
        System.out.println(Account.validateAccountNumber(currentAccount2.getAccountNumber()));

    }
}
