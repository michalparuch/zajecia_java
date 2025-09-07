package basics.o11.oop.przyklady.ograniczenia;

import java.util.ArrayList;
import java.util.List;

public class Doctor {
    public static List<Doctor> extension = new ArrayList<>();
    private Integer maxSalary = 20000;


    private String name, lastName;
    private Integer salary;
    private Integer pesel;
    private PrivateContract privateContract;
    private PublicContract publicContract;

    public Doctor(Integer pesel, Integer salary, String lastName, String name) {
        validatePesel(pesel);

        validateSalary(salary);


        this.pesel = pesel;
        this.salary = salary;
        this.lastName = lastName;
        this.name = name;
        extension.add(this);
    }

    private void validateSalary(Integer salary) {
        if (salary > maxSalary) {
            throw new IllegalArgumentException("Salary must be less than " + maxSalary);
        }
    }

    private static void validatePesel(Integer pesel) {
        for (Doctor doctor : extension) {
            if (doctor.getPesel() == pesel) {
                throw new IllegalArgumentException("Pesel number already used");
            }
        }
    }

    public Integer getPesel() {
        return pesel;
    }

    public Integer getSalary() {
        return salary;
    }

    public PrivateContract getPrivateContract() {
        return privateContract;
    }

    public PublicContract getPublicContract() {
        return publicContract;
    }

    public void setPrivateContract(PrivateContract privateContract) {
        this.privateContract = privateContract;
    }

    public void setPublicContract(PublicContract publicContract) {
        this.publicContract = publicContract;
    }
}
