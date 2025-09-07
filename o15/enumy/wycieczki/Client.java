package basics.o15.enumy.wycieczki;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Client {
    public static Integer counter = 0;

    private Integer iD;
    private String name, surname;
    private List<Trip> tripsList;

    public Client(String surname, String name) {
        this.iD = ++counter;
        this.surname = surname;
        this.name = name;
        this.tripsList = new ArrayList<>();
    }

    public Integer getiD() {
        return iD;
    }

    public List<Trip> getTripsList() {
        return tripsList;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public void addTrip(Trip trip) {
        tripsList.add(trip);
        trip.getClientsList().add(this);
    }

    public Integer getMaxSpentOnExtras() {
        Integer maxSpent = 0;
        for (Trip trip : tripsList) {
            Integer temp = 0;
            for (Extras extras : trip.getExtrasList()) {
                temp += extras.getPrice();
            }
            if (temp > maxSpent) {
                maxSpent = temp;
            }
        }
        return maxSpent;
    }

    public Integer getMaxSpentOnTrip() {
        Integer maxSpent = 0;
        for (Trip trip : tripsList) {
            Integer temp = trip.getPrice();
            for (Extras extras : trip.getExtrasList()) {
                temp += extras.getPrice();
            }
            if (temp > maxSpent) {
                maxSpent = temp;
            }
        }
        return maxSpent;
    }

    public static Map<Client, Integer> getClientWhoSpentTheMostOn(Map<Client, Integer> clients) {
        Map<Client, Integer> output = new HashMap<>();
        Integer max = Integer.MIN_VALUE;

        for (Map.Entry<Client, Integer> entry : clients.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                output.clear();
                output.put(entry.getKey(), entry.getValue());
            }
        }
        return output;
    }


    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
