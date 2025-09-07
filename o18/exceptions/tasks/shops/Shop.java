package basics.o18.exceptions.tasks.shops;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private String name;
    private String town;
    private List<Person> clients = new ArrayList<>();

    public Shop(String name, String town) {
        this.name = name;
        this.town = town;
    }

    public void addClient(Person client){
        if (client.getSex().equals(Sex.MALE)){
            throw new ShopsAreOnlyForWomenException("Shops only for women");
        }
        clients.add(client);
        client.setShop(this);
    }
}
