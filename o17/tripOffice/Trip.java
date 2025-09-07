package basics.o17.tripOffice;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//Klienci rezerwują i kupują wycieczki. Dla wycieczki pamiętamy unikalny id wycieczki, cenę, motyw (Zwiedzanie, wypoczynek lub aktywność) oraz ocenę wycieczki.
//Wycieczki dzielą się na wycieczki krajowe i zagraniczne. Dla wycieczek krajowych przechowujemy miasto, w którym wycieczka się odbedzie, a dla zagranicznych kraj oraz środek transportu.
//Wycieczkki są obsługiwane przez przewodników.
public abstract class Trip implements Serializable {
    public static List<Trip> extension = new ArrayList<>();

    private static Integer count = 0;

    private Integer id;
    private String tripName;
    private Double price;
    private TripTheme tripTheme;
    private Double rating;
    private Guide guide;
    private InfoCard infoCard;

    public Trip(String tripName, Double price, TripTheme tripTheme) {

        this.id = ++count;

        this.tripName = tripName;
        this.price = price;
        this.tripTheme = tripTheme;
        this.rating = null;
        this.guide = null;
        this.infoCard = null; //-> do usunuecia
    }

    public static Integer getCount() {
        return count;
    }

    public Integer getId() {
        return id;
    }

    public String getTripName() {
        return tripName;
    }

    public Double getPrice() {
        return price;
    }

    public TripTheme getTripTheme() {
        return tripTheme;
    }

    public Double getRating() {
        return rating;
    }

    public static void setCount(Integer count) {
        Trip.count = count;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setTripTheme(TripTheme tripTheme) {
        this.tripTheme = tripTheme;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public void setGuide(Guide guide) {
        this.guide = guide;
        guide.addGuideTrips(this);
    }

    public void setInfoCard(InfoCard infoCard) {
        this.infoCard = infoCard;
    }

    public static Trip getTripByName(String name){
        Trip searchedTrip = null;

        for (Trip trip : extension){
            if(trip.getTripName().equals(name)){
                searchedTrip = trip;
                break;
            }
        }
        return searchedTrip;
    }


}
