package basics.o19.dates.zadania.z2.pracownicy;

import basics.o19.dates.zadania.z1.pesel.Local;

import java.time.LocalDate;
import java.util.*;

public class Employee {
    private String name;
    private LocalDate birthDate;

    public static List<Employee> extension = new ArrayList<>();

    public Employee(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        extension.add(this);
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public static Employee getYoungestEmployee() {
        Employee youngestEmployee = extension.getFirst();
        for (Employee employee : extension) {
            if (youngestEmployee.getBirthDate().isBefore(employee.birthDate)) {
                youngestEmployee = employee;
            }
        }
        return youngestEmployee;
    }

    public static List<Employee> getEmployeesBornBeforeDate(LocalDate date) {
        List<Employee> employees = new ArrayList<>();

        for (Employee employee : extension) {
            if (employee.birthDate.isAfter(date)) {
                employees.add(employee);
            }
        }
        return employees;
    }

    public static void sortEmployeesByBirthdate() {
//        for (int i = 0; i < extension.size() - 1; i++) {
//            for (int j = i + 1; j < extension.size(); j++) {
//                if (extension.get(i).getBirthDate().isAfter(extension.get(j).getBirthDate())) {
//                    Employee temp = extension.get(i);
//                    extension.set(i, extension.get(j));
//                    extension.set(j, temp);
//                }
//            }
//        }

        extension.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1.getBirthDate().isBefore(o2.getBirthDate())) {
                    return -1;
                } else if (o1.getBirthDate().isAfter(o2.getBirthDate())) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
    }

    public static void printAll(){
        for (Employee employee : extension){
            System.out.println(employee.getName() + " " + employee.getBirthDate());
        }
    }


}
