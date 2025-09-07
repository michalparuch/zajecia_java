package basics.o18.exceptions.tasks.progrmamers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Woman {
    private String name;
    private String surname;
    private BreastSize breastSize;
    private Integer iq;
    private String favPlace;

    List<String> favPlaces = new ArrayList<>(Arrays.asList("Cinema", "Restaurant", "Walk"));

    public Woman(String name, String surname, BreastSize breastSize, Integer iq) {
        this.name = name;
        this.surname = surname;
        this.breastSize = breastSize;
        this.iq = iq;

        Random rand = new Random();
        this.favPlace = favPlaces.get(rand.nextInt(favPlaces.size()));
    }

    public String getName() {
        return name;
    }

    public List<String> getFavPlaces() {
        return favPlaces;
    }

    public Integer getIq() {
        return iq;
    }

    public String getFavPlace() {
        return favPlace;
    }

    public BreastSize getBreastSize() {
        return breastSize;
    }

    public String getSurname() {
        return surname;
    }
}
