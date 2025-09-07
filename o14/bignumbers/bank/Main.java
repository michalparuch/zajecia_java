package basics.o14.bignumbers.bank;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        // Stworz krotki system bankowy oparty na klasie BigDecimal. Stworz klase Klient
        // i Konto. Klient moze miec wiele kont. Konto powinno miec metody
        // deposit(BigDecimal b) i withdraw(BigDecimal b). Przeprowadz symulacje
        // wplacania i wyplacania pieniedzy.
        // Dodaj swoje metody pozwalajace na ciekawe operacje na koncie np naliczenie
        // odsetek gdy stan konta jest ujemny, dodanie odsetek gdy ktos ma duzo pieniedzy itp
        // Znajdz konto ktore ma najwiecej hajsu
        // Znajdz konto ktore miało najwiecej transakcji
        // Znajdz znajdz wszystkie konta z ujemnym balansem

        Client client1 = new Client("Jan", "Kowalski");
        Client client2 = new Client("Anna", "Nowak");


        Account acc1 = new Account(client1);
        Account acc2 = new Account(client1);
        Account acc3 = new Account(client2);


        acc1.depositBalance(new BigDecimal("1000.00"));
        acc1.withdrawBalance(new BigDecimal("200.00"));
        acc1.withdrawBalance(new BigDecimal("900.00"));


        acc2.depositBalance(new BigDecimal("5000.00"));


        acc3.depositBalance(new BigDecimal("10000.00"));
        acc3.withdrawBalance(new BigDecimal("2500.00"));
        acc3.depositBalance(new BigDecimal("500.00"));
        acc3.withdrawBalance(new BigDecimal("8000.00"));

        acc1.calculateInterests();
        acc2.calculateInterests();
        acc3.calculateInterests();


        Account mostBalance = acc1.getAccountWithMostBalance();
        System.out.println("Konto z największym stanem konta: " + mostBalance);


        Account mostTransactions = acc1.getAccountWithMostTransactions();
        System.out.println("Konto z największą liczbą transakcji: " + mostTransactions);


        System.out.println("Konta z ujemnym saldem:");
        for (Account a : acc1.getAccountsWithNegativeBalance()) {
            System.out.println(a);
        }


        System.out.println("\nTransakcje dla konta 1:");
        for (Transaction t : acc1.getTransactionsList()) {
            System.out.println(t);
        }

        System.out.println("\nTransakcje dla konta 3:");
        for (Transaction t : acc3.getTransactionsList()) {
            System.out.println(t);

        }
    }
}
