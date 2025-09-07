package basics.o16.interfejsy.tasks.hierarchy;

public abstract class AbstractClient {
    private static Integer iD = 0;
    private Integer clientId;
    private String name;
    private String surname;

    public AbstractClient(String surname, String name) {
        this.clientId = ++iD;
        this.surname = surname;
        this.name = name;
    }

    public Integer getClientId() {
        return clientId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

}
