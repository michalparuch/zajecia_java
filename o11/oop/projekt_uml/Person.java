package basics.o11.oop.projekt_uml;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public abstract class Person {

    private String name, lastName;
    private Integer age;
    private String email;
    private LocalDate bornDate;
    // TODO atrybut wyliczalny salary - powinien byc tylko zwrotka z metody, nie polem w klasie
    private Double salary;
    private List<String> specializations;


    public Person(String name, String lastName, LocalDate bornDate, String email, List<String> specializations) {
        this.name = name;
        this.bornDate = bornDate;
        this.email = email;
        calculateAge();
        this.lastName = lastName;
        this.specializations = specializations;
    }

    public Person(String name, String lastName, LocalDate bornDate, List<String> specializations) {
        this.name = name;
        this.lastName = lastName;
        this.bornDate = bornDate;
        calculateAge();
        //this.salary = calculateSalary();
        this.specializations = specializations;
    }

    public void calculateAge() {
        this.age = LocalDate.now().getYear() - bornDate.getYear();
    }

    public abstract void calculateSalary();

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void salaryRise(double percentage) {
        // TODO te 10% wyniesc do atrbutu klasowego (jakis static)
        if (percentage > 10.00) {
            throw new IllegalArgumentException("Salary rise can't be > 10%");
        }
        salary += salary * (percentage / 100);
        // max salary tak samo jako atrybut klasowy
        if (salary > 5000.00) {
            salary = 5000.00;
        }
    }

    public String getName() {
        return name;
    }

    public LocalDate getBornDate() {
        return bornDate;
    }

    public String getEmail() {
        return email;
    }

    public Integer getAge() {
        return age;
    }

    public String getLastName() {
        return lastName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBornDate(LocalDate bornDate) {
        this.bornDate = bornDate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(lastName, person.lastName) && Objects.equals(age, person.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, age);
    }

    public Double getSalary() {
        return salary;
    }
}
