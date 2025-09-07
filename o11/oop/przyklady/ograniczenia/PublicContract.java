package basics.o11.oop.przyklady.ograniczenia;

import java.util.ArrayList;
import java.util.List;

public class PublicContract {
    private Integer nextID = 1;

    private Integer id;
    private String name;
    private List<Doctor> listOfDoctorsPublic = new ArrayList<>();

    public PublicContract(String name) {
        this.id = nextID++;
        this.name = name;
    }

    public void addDoctor(Doctor doctor) {
        if (doctor.getPrivateContract() == null && doctor.getPublicContract() == null) {
            listOfDoctorsPublic.add(doctor);
            doctor.setPublicContract(this);
        } else {
            throw new IllegalArgumentException("Doctor already has contract");
        }
    }

    public Integer getNextID() {
        return nextID;
    }

    public List<Doctor> getListOfDoctorsPublic() {
        return listOfDoctorsPublic;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "PublicContract{" +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
