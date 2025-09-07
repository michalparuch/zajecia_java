package basics.o17.tripOffice;

import java.io.Serializable;

public class Manager extends Employee implements Serializable {
    private Double lastBonus;
    private EmploymentType employmentType;
    private String agreementType;

    public Manager(String name, String phoneNumber, String email, String surname, Double salary, Double minSalary) {
        super(name, phoneNumber, email, surname, salary, minSalary);
        this.employmentType = EmploymentType.NORMAL_EMPLOYEE;
        extension.add(this);
    }

    public Manager(String name, String phoneNumber, String email, String surname, Double salary, Double minSalary, EmploymentType employmentType, String agreementType) {
        super(name, phoneNumber, email, surname, salary, minSalary);
        this.employmentType = employmentType;
        this.agreementType = agreementType;
        extension.add(this);
    }

    public void setLastBonus(Double lastBonus) {
        this.lastBonus = lastBonus;
    }

}
