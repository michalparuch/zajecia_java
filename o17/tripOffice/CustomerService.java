package basics.o17.tripOffice;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CustomerService extends Employee implements Serializable {
    private Integer employeeRanking;
    private EmploymentType employmentType;
    private String agreementType;
    private List<Ticket> ticketList;

    public CustomerService(String name, String phoneNumber, String email, String surname, Double salary, Double minSalary) {
        super(name, phoneNumber, email, surname, salary, minSalary);
        this.employmentType = EmploymentType.NORMAL_EMPLOYEE;
        this.ticketList = new ArrayList<>();
        extension.add(this);
    }

    public CustomerService(String name, String phoneNumber, String email, String surname, Double salary, Double minSalary, EmploymentType employmentType, String agreementType) {
        super(name, phoneNumber, email, surname, salary, minSalary);
        this.employmentType = employmentType;
        this.agreementType = agreementType;
        this.ticketList = new ArrayList<>();
        extension.add(this);
    }

    public void setEmployeeRanking(Integer ranking) {
        employeeRanking = ranking;
    }

    public Integer getEmployeeRanking() {
        return employeeRanking;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public EmploymentType getEmploymentType() {
        return employmentType;
    }

    public String getAgreementType() {
        return agreementType;
    }

    public void ticketMessage(Ticket ticket, String text) {
        Message message = new Message(ticket, text);
        message.setSentBy(this);
        ticket.addMessage(message);
    }

    public void pickUpTicket(Integer id) {
        Ticket ticket = Ticket.getTicketById(id);
        if (ticket.getCustomerService() == null) {
            ticket.setCustomerService(this);
            ticketList.add(ticket);
        } else {
            throw new IllegalArgumentException("This ticket already has assigned employee");
        }
    }
}
