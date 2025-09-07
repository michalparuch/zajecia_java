package basics.o11.oop.przyklady.ograniczenia;

import java.util.ArrayList;
import java.util.List;

public class PrivateContract {
    private String name;
    private List<Doctor> listOfDoctorsPrivate = new ArrayList<>();

    public PrivateContract(String name) {
        this.name = name;
    }

    public void addDoctor(Doctor doctor){
        if(doctor.getPrivateContract()==null && doctor.getPublicContract()==null){
            listOfDoctorsPrivate.add(doctor);
            doctor.setPrivateContract(this);
        } else {
            throw new IllegalArgumentException("Doctor already has contract");
        }
    }

    public String getName() {
        return name;
    }

    public List<Doctor> getListOfDoctorsPrivate() {
        return listOfDoctorsPrivate;
    }

    @Override
    public String toString() {
        return "PrivateContract{" +
                "name='" + name + '\'' +
                '}';
    }
}

