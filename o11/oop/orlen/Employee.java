package basics.o11.oop.orlen;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Employee {
    private static Set<String> usedPesels = new HashSet<>();

    private String pesel;
    private String name;
    private LocalDate dateOfBirth;
    private Character sex;
    private Double efficiency;
    private Boolean canBeFired;

    public Employee(String pesel, String name, LocalDate dateOfBirth, Character sex, Double efficiency) {
        validatePesel(pesel, sex);
        this.pesel = pesel;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.efficiency = efficiency;
        this.setCanBeFired();
    }

    private static void validatePesel(String pesel, Character sex) {
        if (!sex.equals('M') && !sex.equals('F')) {
            throw new IllegalArgumentException("Incorrect Gender");
        }
        if (pesel.length() != 10){
            throw new IllegalArgumentException("Pesel number must have length of 10");
        }
        if (usedPesels.contains(pesel)) {
            throw new IllegalArgumentException("Pesel number already used");
        } else {
            usedPesels.add(pesel);
        }
    }

    public void setCanBeFired() {
        if (this.sex.equals('F')) {
            canBeFired = LocalDate.now().getYear() - dateOfBirth.getYear() < 55;
        }
        if (this.sex.equals('M')) {
            canBeFired = LocalDate.now().getYear() - dateOfBirth.getYear() < 60;
        }
    }

    public String getPesel() {
        return pesel;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Character getSex() {
        return sex;
    }

    public Double getEfficiency() {
        return efficiency;
    }

    public Boolean getCanBeFired() {
        return canBeFired;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "pesel='" + pesel + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
