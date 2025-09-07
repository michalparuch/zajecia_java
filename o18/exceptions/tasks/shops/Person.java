package basics.o18.exceptions.tasks.shops;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String surname;
    private String town;
    private Integer age;
    private Sex sex;
    private Person dating;
    private Shop shop;

    public static List<Person> extension = new ArrayList<>();

    public Person(String name, String surname, Integer age, Sex sex, String town) {
        this.name = name;
        this.surname = surname;

        try {
            if (age < 18) {
                throw new UnderageException("Underage");
            }
            this.age = age;
        } catch (UnderageException e) {
            System.out.println(e.getMessage());
            this.age = 18;
        }

        this.sex = sex;
        this.town = town;
        extension.add(this);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getTown() {
        return town;
    }

    public Integer getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    public Person getDating() {
        return dating;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public void setDating(Person dating) {
        this.dating = dating;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public void goOnDate(Person partner) {
        if (this.sex.equals(partner.sex)) {
            throw new NoHomoHereException("No homo");
        }
        this.dating = partner;
        partner.setDating(this);
    }

    public Person getOldestWoman() {
        Person oldestWoman = null;

        for (Person person : extension) {
            if (person.getSex().equals(Sex.FEMALE)) {
                if (oldestWoman == null || oldestWoman.getAge() < person.getAge()) {
                    oldestWoman = person;
                }
            }
        }
        if (oldestWoman == null) {
            throw new NoWomenException("No woman in system");
        }
        return oldestWoman;

    }

}
