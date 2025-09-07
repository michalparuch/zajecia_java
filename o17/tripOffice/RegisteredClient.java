package basics.o17.tripOffice;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RegisteredClient extends Client implements Serializable {
    private static Integer counter = 0;

    private Integer id;
    private List<Ticket> ticketList;
    private List<Trip> bookedTrips;

    public RegisteredClient(String name, String phoneNumber, String email, String surname) {
        super(name, phoneNumber, email, surname);
        this.ticketList = new ArrayList<>();
        this.id = ++counter;
        this.bookedTrips = new ArrayList<>();
        extension.add(this);
    }

    public void createTicket(Ticket ticket) {
        ticketList.add(ticket);
        if(!(ticket.getCustomerService() == null)){
            ticket.getCustomerService().getTicketList().add(ticket);
        }
        System.out.println("Ticket " + ticket.getTopic() + " has been created");
    }

    public void ticketMessage(Ticket ticket, String text) {
        Message message = new Message(ticket, text);
        message.setSentBy(this);
        ticket.addMessage(message);
    }

    public void bookTrip(Trip trip){
        bookedTrips.add(trip);
    }

    public Double getTotalSpent(){
        Double sum = 0.0;
        for (Trip trip : bookedTrips){
            sum += trip.getPrice();
        }
        return sum;
    }

    public void displayClientTrips(){
        for(Trip trip : bookedTrips){
            System.out.println(trip);
        }
    }

    public Integer getId() {
        return id;
    }

    public static Integer getCounter() {
        return counter;
    }

    public List<Trip> getBookedTrips() {
        return bookedTrips;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    @Override
    public String toString() {
        return "RegisteredClient{" +
                "id=" + id +
                ", name='" + super.getName() + ' ' +
                ", surname='" + super.getSurname() + '\'' +
                ", totalSpent=" + getTotalSpent() +
                '}';
    }
}
