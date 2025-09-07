package basics.o11.oop.employees;

import basics.o11.oop.clients.Product;

import java.util.*;

public class Client {
    private static List<Client> extension = new ArrayList<>();

    private String name;
    private String surname;
    private List<Product> purchased;

    public Client(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.purchased = new ArrayList<>();
        extension.add(this);
    }


    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", surename='" + surname + '\'' +
                ", purchased=" + purchased +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(name, client.name) && Objects.equals(surname, client.surname) && Objects.equals(purchased, client.purchased);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, purchased);
    }

    public void setPurchased(List<Product> purchased) {
        this.purchased = purchased;
    }

    public void addProduct(Product product) {
        this.purchased.add(product);
    }

    public static Client getClientWhoSpendTheMost() {
        Client mostValuableClient = null;
        Integer totalSpend = 0;

        for (Client client : extension) {
            Integer tempSum = 0;
            for (Product product : client.purchased) {
                tempSum += product.getPrice();
            }
            if (mostValuableClient == null || tempSum > totalSpend) {
                mostValuableClient = client;
                totalSpend = tempSum;
            }
        }
        return mostValuableClient;
    }

    public Product getFavProduct() {
        HashMap<Product, Integer> frequency = new HashMap<>();

        for (Product product : purchased) {
//            if (frequency.get(product) == null) {
            if (!frequency.containsKey(product)) {
                frequency.put(product, 1);
            } else {
                frequency.put(product, frequency.get(product) + 1);
            }
        }

        Product favouriteProduct = null;
        Integer maxProductCount = 0;

        for (Map.Entry<Product, Integer> entry : frequency.entrySet()){
            if(entry.getValue() > maxProductCount){
                favouriteProduct = entry.getKey();
                maxProductCount = entry.getValue();
            }
        }
        return favouriteProduct;
    }

}
