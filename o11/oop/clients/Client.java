package basics.o11.oop.clients;

import basics.o11.oop.basics.Car;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private static List<Client> extention = new ArrayList<>();

    private String name;
    private String surname;
    private Integer size;
    private List<Product> products;

    public Client(String name, String surname, Integer size) {
        this.name = name;
        this.surname = surname;
        this.size = size;
        this.products = new ArrayList<>();
        extention.add(this);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public static Client getClientWhoSpendTheMost() {
        Integer maxSpent = 0;
        Client bestClient = null;

        for (Client client : extention) {
            Integer sum = 0;
            for (Product product : client.products) {
                sum += product.getPrice();
            }
            if (sum > maxSpent || bestClient == null) {
                maxSpent = sum;
                bestClient = client;
            }
        }
        return bestClient;
    }

    public static List<Client> getClientsWhoBoughtCap() {
        List<Client> clientWithCap = new ArrayList<>();

        for (Client client : extention) {
            for (Product product : client.products) {
                if (product.getSize() != null) {
                    clientWithCap.add(client);
                }
            }
        }
        return clientWithCap;
    }

    public Integer getSize() {
        return size;
    }

    public static List<Client> getClientsWithWrongCapSize() {
        List<Client> getClientsWithWrongSizeList = new ArrayList<>();

        for (Client client : extention) {
            Integer clientHeadSize = client.getSize();
            for (Product product : client.products) {
                if (product.getSize() != clientHeadSize && product.getSize() != null) {
                    getClientsWithWrongSizeList.add(client);
                    break;
                }
            }
        }
        return getClientsWithWrongSizeList;
    }

    @Override
    public String toString() {
        return "Client{name='" + name + "', surname='" + surname + "', size=" + size + "}";
    }
}
