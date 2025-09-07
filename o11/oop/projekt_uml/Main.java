package basics.o11.oop.projekt_uml;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String name = "Jan";
        String lastName = "Kowalski";
        LocalDate bornDate = LocalDate.of(1990, 5, 15);
        String email = "jan.kowalski@example.com";

        List<String> specialization = Arrays.asList("Transport", "Logistyka");
        List<String> drivingLicences = Arrays.asList("B", "C");

        Driver driver = new Driver(name, lastName, bornDate, email, specialization, drivingLicences);
        Driver driver2 = new Driver("Adam", lastName, bornDate, email, specialization, drivingLicences);

        System.out.println("Imię: " + driver.getName());
        System.out.println("Nazwisko: " + driver.getLastName());
        System.out.println("Wiek: " + driver.getAge());
        System.out.println("Email: " + driver.getEmail());
        System.out.println("Specjalizacje: " + driver.getDriverLicenceCategories());
        System.out.println("Pensja: " + driver.getSalary());

        driver.salaryRise(10.00);
        System.out.println("Pensja: " + driver.getSalary());
        driver.salaryRise(5.00);
        System.out.println("Pensja: " + driver.getSalary());

//        Car car = new Car("M4", "BMW", 2022, 4.0);
//
//        driver.useCar(car);
//        driver2.useCar(car);
//
//        System.out.println("Lista kierowców:");
//        for (Driver d : car.getDriversList()) {
//            System.out.println(d.getName() + " " + d.getLastName());
//        }

    }
}
