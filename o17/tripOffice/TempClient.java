package basics.o17.tripOffice;

import java.io.Serializable;

public class TempClient extends Client implements Serializable {

    private Trip bookedTrip;

    public TempClient(String name, String phoneNumber, String email, String surname, Trip bookedTrip) {
        super(name, phoneNumber, email, surname);
        this.bookedTrip = bookedTrip;
        extension.add(this);
    }


    public Double getTotalSpent() {
        if (bookedTrip != null) {
            return bookedTrip.getPrice();
        } else {
            return 0.00;
        }
    }

    public Trip getBookedTrip() {
        return bookedTrip;
    }

    @Override
    public String toString() {
        return "TempClient{" +
                ", name='" + super.getName() + ' ' +
                ", surname='" + super.getSurname() + '\'' +
                ", totalSpent=" + getTotalSpent() +
                '}';

    }
}
