package basics.o17.tripOffice;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Ticket implements Serializable {

    @Serial
    private static final long serialVersionUID = 20250826123456789L;

    public static List<Ticket> extension = new ArrayList<>();

    private static int counter = 0;
    private int id;
    private RegisteredClient registeredClient;
    private CustomerService customerService;
    private LocalDateTime date;
    private String topic;
    private List<Message> messages;

    public Ticket(RegisteredClient registeredClient, CustomerService customerService, String topic) {
        this.registeredClient = registeredClient;
        this.customerService = customerService;
        this.topic = topic;
        this.messages = new ArrayList<>();
        this.date = LocalDateTime.now();
        this.id = ++counter;
        extension.add(this);
    }

    public RegisteredClient getRegisteredClient() {
        return registeredClient;
    }

    public CustomerService getCustomerService() {
        return customerService;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getTopic() {
        return topic;
    }

    public void setRegisteredClient(RegisteredClient registeredClient) {
        this.registeredClient = registeredClient;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public Integer getID() {
        return id;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void addMessage(Message message){
        messages.add(message);
    }

    public static Ticket getTicketById(Integer id){
        Ticket searchedTicket = null;

        for (Ticket ticket : extension){
            if(ticket.getID().equals(id)){
                searchedTicket = ticket;
            }
        }
        if(searchedTicket != null){
            return searchedTicket;
        } else {
            throw  new IllegalArgumentException("Ticket id not found!");
        }
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", topic='" + topic + '\'' +
                '}';
    }

    public  void displayTicketMessages(){
        for(Message message : messages){
            System.out.println(message);
        }
    }
}
