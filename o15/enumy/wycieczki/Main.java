package basics.o15.enumy.wycieczki;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        /*
         * Stwórz klase klient i wycieczka, klient moze miec wiele wycieczek, wycieczka
         * moze miec wielu klientow. Wycieczka ma nazwe, kraj, cena i liste dodatkow
         * (kazdy jest dodatkowo platny) Znadz klienta który wydal najwiecej na dodatki
         * do wycieczki uwzgledniajac tez cene wycieczki Znadz klienta który wydal
         * najwiecej na dodatki do wycieczki nieuwzgledniajac tez ceny wycieczki
         */

        Client client1 = new Client("Kowalski", "Jan1");
        Client client2 = new Client("Kowalski", "Jan2");
        Client client3 = new Client("Kowalski", "Jan3");

        Trip trip1 = new Trip("Wycieczka po USA", Country.USA, 10000, Arrays.asList(Extras.BREAKFAST, Extras.CAR_RENTAL));
        Trip trip2 = new Trip("Wycieczka po Hiszpani", Country.SPAIN, 5000, Arrays.asList(Extras.ALLINCLUSIVE, Extras.POOL));
        Trip trip3 = new Trip("Wycieczka po Polsce", Country.USA, 2000, Arrays.asList(Extras.BREAKFAST));

        client1.addTrip(trip1);
        client2.addTrip(trip2);
        client3.addTrip(trip3);

        Map<Client, Integer> clientExpensesOnExtras = new HashMap<>();
        Map<Client, Integer> clientExpensesOnWholeTrip = new HashMap<>();

        clientExpensesOnWholeTrip.put(client1, client1.getMaxSpentOnTrip());
        clientExpensesOnWholeTrip.put(client2, client2.getMaxSpentOnTrip());
        clientExpensesOnWholeTrip.put(client3, client3.getMaxSpentOnTrip());

        clientExpensesOnExtras.put(client1, client1.getMaxSpentOnExtras());
        clientExpensesOnExtras.put(client2, client2.getMaxSpentOnExtras());
        clientExpensesOnExtras.put(client3, client3.getMaxSpentOnExtras());

        System.out.println(Client.getClientWhoSpentTheMostOn(clientExpensesOnExtras));
        System.out.println(Client.getClientWhoSpentTheMostOn(clientExpensesOnWholeTrip));
    }
}
