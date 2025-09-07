package basics.o17.tripOffice;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Client extends AbstractPerson implements Serializable {
    public static List<Client> extension = new ArrayList<>();

    public Client(String name, String phoneNumber, String email, String surname) {
        super(name, phoneNumber, email, surname);
    }

    public abstract Double getTotalSpent();

    public static Client getClientWhoSpentTheMost() {
        Client bestClient = extension.getFirst();

        for (Client client : extension) {
            if (client.getTotalSpent() > bestClient.getTotalSpent()) {
                bestClient = client;
            }
        }
        return bestClient;
    }

    public static List<Client> getAllClientsList() {
        List<Client> clientList = new ArrayList<>(extension);
        return clientList;
    }

    public static void removeClient(Integer id) {
        Client toRemove = null;
        for (Client client : extension) {
            if (client instanceof RegisteredClient) {
                RegisteredClient rc = (RegisteredClient) client;
                if (rc.getId().equals(id)) {
                    toRemove = client;
                    break;
                }
            }
        }
        if (toRemove != null) {
            extension.remove(toRemove);
            System.out.println("Client with ID " + id + " removed.");
        } else {
            System.out.println("Client with ID " + id + " not found.");
        }
    }

    public static RegisteredClient getClientByID(Integer id) {
        RegisteredClient output = null;
        for (Client client : extension) {
            if (client instanceof RegisteredClient) {
                if (((RegisteredClient) client).getId().equals(id)) {
                    output = (RegisteredClient) client;
                    break;
                }
            }
        }
        if (output != null) {
            return output;
        } else {
            throw new IllegalArgumentException("Client with ID " + id + " not found.");
        }
    }

}
