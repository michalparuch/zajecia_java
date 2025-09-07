package basics.o17.tripOffice;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Employee extends AbstractPerson implements Serializable {
    public static List<Employee> extension = new ArrayList<>();

    private Double salary;
    private Double minSalary;
    private Map<LocalDate, Integer> hoursWorked;

    public Employee(String name, String phoneNumber, String email, String surname, Double salary, Double minSalary) {
        super(name, phoneNumber, email, surname);
        this.salary = salary;
        this.minSalary = minSalary;
        this.hoursWorked = new HashMap<>();
    }

    public Double getSalary() {
        return salary;
    }

    public Map<LocalDate, Integer> getHoursWorked() {
        return hoursWorked;
    }

    public Double getMinSalary() {
        return minSalary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setMinSalary(Double minSalary) {
        this.minSalary = minSalary;
    }

    public void setHoursWorked(Map<LocalDate, Integer> hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public void addWorkedHours(LocalDate date, Integer hours) {
        hoursWorked.put(date, hours);
    }

    public static CustomerService getCustomerServiceEmployee(String surname) {
        CustomerService searchedEmployee = null;

        for (Employee employee : extension) {
            if (employee instanceof CustomerService) {
                searchedEmployee = (CustomerService) employee;
                break;
            }
        }

        if (searchedEmployee != null) {
            return searchedEmployee;
        } else {
            throw new IllegalArgumentException("Employee not found!");
        }
    }

}
