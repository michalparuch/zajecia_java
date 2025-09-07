package basics.o17.tripOffice;

import java.io.Serializable;

public class ForeignTrip extends Trip implements Serializable {
    private String country;
    private TransportMode transportMode;

    public ForeignTrip(String tripName, Double price, TripTheme tripTheme, String country, TransportMode transportMode) {
        super(tripName, price, tripTheme);
        this.country = country;
        this.transportMode = transportMode;
        extension.add(this);
    }

    public String getCountry() {
        return country;
    }

    public TransportMode getTransportMode() {
        return transportMode;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setTransportMode(TransportMode transportMode) {
        this.transportMode = transportMode;
    }

    @Override
    public String toString() {
        return "ForeignTrip{" +
                "name=" + super.getTripName() +
                "price=" + super.getPrice() +
                "country=" + country +
                ", transportMode=" + transportMode +
                '}';
    }
}
