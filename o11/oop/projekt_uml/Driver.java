package basics.o11.oop.projekt_uml;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Driver extends Person {
    private List<String> driverLicenceCategories = new ArrayList<>();
    private Car usingCar;
    private List<DriverCourse> driverCourses = new ArrayList<>();

    public Driver(String name, String lastName, LocalDate bornDate, String email, List<String> specialization, List<String> driverLicenceCategories) {
        super(name, lastName, bornDate, email, specialization);
        if (driverLicenceCategories.isEmpty()) {
            throw new IllegalArgumentException("At least one driving license category is required");
        }
        this.driverLicenceCategories = driverLicenceCategories;
        calculateSalary();
    }

    public Driver(String name, String lastName, LocalDate bornDate, List<String> specialization, List<String> driverLicenceCategories) {
        super(name, lastName, bornDate, specialization);
        if (driverLicenceCategories.isEmpty()) {
            throw new IllegalArgumentException("At least one driving license category is required");
        }
        this.driverLicenceCategories = driverLicenceCategories;
        calculateSalary();
    }

    public void addDriverCourse(DriverCourse dc) {
        driverCourses.add(dc);
    }

    @Override
    public void calculateSalary() {
        setSalary(3500.00 + driverLicenceCategories.size() * 100.00);
    }

    public List<String> getDriverLicenceCategories() {
        return driverLicenceCategories;
    }

    public void useCar(Car car){
        usingCar = car;
        if(!car.getDriversList().contains(this)){
            car.getDriversList().add(this);
        }
    }

    public List<DriverCourse> getDriverCourses() {
        return driverCourses;
    }
}

