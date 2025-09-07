package basics.o17.tripOffice;

import java.io.Serializable;

public class DomesticTrip extends Trip implements Serializable {

    private String town;

    public DomesticTrip(String tripName, Double price, TripTheme tripTheme, String town) {
        super(tripName, price, tripTheme);
        this.town = town;
        extension.add(this);
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Override
    public String toString() {
        return "DomesticTrip{" +
                "name=" + super.getTripName() +
                "price=" + super.getPrice() +
                "town='" + town + '\'' +
                '}';
    }
}
