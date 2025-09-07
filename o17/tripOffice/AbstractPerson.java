package basics.o17.tripOffice;

import java.io.Serializable;

public abstract class AbstractPerson implements Serializable {
    //imię, nazwisko, adresy mailowe oraz telefon
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;

    public AbstractPerson(String name, String phoneNumber, String email, String surname) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }
}
