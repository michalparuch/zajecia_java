package basics.o15.enumy.wycieczki;

import java.util.ArrayList;
import java.util.List;

public class Trip {
    private String name;
    private Country country;
    private Integer price;
    private List<Extras> extrasList;
    private List<Client> clientsList;

    public Trip(String name, Country country, Integer price, List<Extras> extrasList) {
        this.name = name;
        this.country = country;
        this.price = price;
        this.extrasList = extrasList;
        this.clientsList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public Country getCountry() {
        return country;
    }

    public List<Extras> getExtrasList() {
        return extrasList;
    }

    public List<Client> getClientsList() {
        return clientsList;
    }

    public void addExtras(Extras extra){
        extrasList.add(extra);
    }
}
