package basics.o11.oop.employees;

import basics.o11.oop.basics.Car;
import basics.o11.oop.clients.Product;

import java.util.*;

public class Employee {
    private static List<Employee> extention = new ArrayList<>();

    private String name;
    private String surename;
    private String adress;
    private Integer salary;
    private HashMap<Car, Integer> cars;


    public Employee(String name, String surename, String adress, Integer salary) {
        this.name = name;
        this.surename = surename;
        this.adress = adress;
        this.salary = salary;
        this.cars = new HashMap<>();
        extention.add(this);
    }

    public Integer getSalary() {
        return salary;
    }

    public HashMap<Car, Integer> getCars() {
        return cars;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surename='" + surename + '\'' +
                ", adress='" + adress + '\'' +
                ", salary=" + salary +
                ", car=" + cars +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(surename, employee.surename) && Objects.equals(adress, employee.adress) && Objects.equals(salary, employee.salary) && Objects.equals(cars, employee.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surename, adress, salary, cars);
    }

    public static Employee[] getTop3() {
        Employee[] top3Salaries = new Employee[3];

        for (Employee employee : extention) {
            for (int i = 0; i < top3Salaries.length; i++) {
                if (top3Salaries[i] == null) {
                    top3Salaries[i] = employee;
                    break;
                } else if (employee.getSalary() > top3Salaries[i].getSalary()) {
                    for (int j = top3Salaries.length - 1; j > i; j--) {
                        top3Salaries[j] = top3Salaries[j - 1];
                    }
                    top3Salaries[i] = employee;
                    break;
                }
            }
        }

        return top3Salaries;
    }

    public void useCar(Car car){
        if(cars.get(car) == null){
            cars.put(car, 1);
        } else {
            cars.put(car, cars.get(car) + 1);
        }
    }
}
