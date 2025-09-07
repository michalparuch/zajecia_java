package basics.o18.exceptions.tasks;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String name;
    private List<Product> products = new ArrayList<>();

    public Client(String name) {
        this.name = name;
    }

    public void addProduct(Product product) {
        try {
            if (product == null) {
                throw new NullPointerException("Null value");
            }
            products.add(product);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            products.add(new Product("Lamborghini", 10000000));
        }
    }

    public void printProducts() {
        System.out.println(name + ": ");
        for (Product p : products) {
            System.out.println("- " + p.getName() + " " + p.getPrice());
        }
    }
}

