package basics.o17.tripOffice;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Message implements Serializable {
    private Ticket ticket;
    private Integer messageID = 0;
    private String messageText;
    private AbstractPerson sentBy;
    private LocalDateTime dateTime;

    public Message(Ticket ticket, String messageText) {
        this.ticket = ticket;
        this.messageText = messageText;
        this.dateTime = LocalDateTime.now();
    }

    public Ticket getTicket() {
        return ticket;
    }

    public AbstractPerson getSentBy() {
        return sentBy;
    }

    public String getMessageText() {
        return messageText;
    }

    public Integer getMessageID() {
        return messageID;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public void setSentBy(AbstractPerson sentBy) {
        this.sentBy = sentBy;
    }

    public void setMessageID(Integer messageID) {
        this.messageID = messageID;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageText='" + messageText + '\'' +
                ", sentBy=" + sentBy +
                ", dateTime=" + dateTime +
                '}';
    }
}
