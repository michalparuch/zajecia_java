package basics.o19.dates.zadania.z2.pracownicy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class Main {
    public static void main(String[] args) {

        //Stworz praconwika imie, data urodzenia
        //Znajdz najmlodszego Pracownika
        //Znajdz pracownikow ktorzy sa urodzeni po 11.04.2003
        //Posortuj pracownikow po datach urodzenia

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        Employee employee1 = new Employee("Jan", LocalDate.parse("23-11-1998", formatter));
        Employee employee2 = new Employee("Pawel", LocalDate.parse("23-11-2004", formatter));
        Employee employee3 = new Employee("Michal", LocalDate.parse("23-11-1992", formatter));
        Employee employee4 = new Employee("Krzys", LocalDate.parse("23-11-2003", formatter));
        Employee employee5 = new Employee("Grzegorz", LocalDate.parse("23-11-1991", formatter));

        System.out.println("-------");
        System.out.println(Employee.getYoungestEmployee().getName() + " " + Employee.getYoungestEmployee().getBirthDate());
        System.out.println("-------");
        for (Employee employee : Employee.getEmployeesBornBeforeDate(LocalDate.parse("11-04-2003", formatter))) {
            System.out.println(employee.getName() + " " + employee.getBirthDate());
        }
        System.out.println("-------");
        Employee.printAll();
        System.out.println("-------");
        Employee.sortEmployeesByBirthdate();
        Employee.printAll();


    }
}
