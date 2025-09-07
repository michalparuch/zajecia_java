package basics.o11.oop.clients;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        /*
         * Klient kupuje produkty. Klient ma imie nazwisko i rozmiar czapki. Pordukt ma nazwe, cene i jesli jest to czapka to wymiar.
         *  Klient moze miec wiele produktow, produkt moze miec jednego klienta.
         *
         *  1) Napisz mrtode ktota znajduje klienta ktory wydal najwiecej.
         *
         *   2) napisz metode ktora zwroci liste klientow ktorzy kupili czapke
         *
         *   3) napisz metode ktora zwroci liste klientow ktorzy kupili czapke ale nie na swoj rozmiar
         */

        Client client1 = new Client("Jan", "Kowalski", 40);
        Client client2 = new Client("Stefan", "Stefanski", 50);
        Client client3 = new Client("Kacper", "Kacpersky", 55);

        client1.addProduct(new Product("Czapka", 10, 40));
        client1.addProduct(new Product("Koszulka", 20));
        client1.addProduct(new Product("Czapka", 40, 40));

        client2.addProduct(new Product("Czapka", 125, 40));
        client2.addProduct(new Product("Koszulka", 40));

        client3.addProduct(new Product("Koszulka", 40));

        //ZADANIE 1
        System.out.println(Client.getClientWhoSpendTheMost());

        //ZADANIE 2
        System.out.println(Client.getClientsWhoBoughtCap());

        //ZADANIE 3
        System.out.println(Client.getClientsWithWrongCapSize());

    }
}
