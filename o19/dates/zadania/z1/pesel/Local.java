package basics.o19.dates.zadania.z1.pesel;

public class Local {
    private String name;
    private String place;
    private Integer minAge;

    public Local(String name, String place, Integer minAge) {
        this.name = name;
        this.place = place;
        this.minAge = minAge;
    }

    public String getName() {
        return name;
    }

    public String getPlace() {
        return place;
    }

    public Integer getMinAge() {
        return minAge;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setMinAge(Integer minAge) {
        this.minAge = minAge;
    }
}
