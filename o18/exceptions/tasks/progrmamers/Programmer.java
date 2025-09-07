package basics.o18.exceptions.tasks.progrmamers;

import java.util.ArrayList;
import java.util.List;

public class Programmer {
    private String name;
    private String surname;
    private Double salary;
    private List<String> programmingLanguages = new ArrayList<>();

    public static List<Programmer> extension = new ArrayList<>();

    public Programmer(String name, String surname, Double salary) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        extension.add(this);
    }

    public List<String> getProgrammingLanguages() {
        return programmingLanguages;
    }

    public Double getSalary() {
        return salary;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public static List<Programmer> getExtension() {
        return extension;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setProgrammingLanguages(List<String> programmingLanguages) {
        this.programmingLanguages = programmingLanguages;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public static void setExtension(List<Programmer> extension) {
        Programmer.extension = extension;
    }

    public Programmer programmerWithHighestSalary() {
        Programmer hihgestSalaryProgrammer = null;

        for (Programmer programmer : extension) {
            if (programmer.getProgrammingLanguages().contains("Java")) {
                if (hihgestSalaryProgrammer == null || hihgestSalaryProgrammer.getSalary() < programmer.getSalary()) {
                    hihgestSalaryProgrammer = programmer;
                }
            }
        }

        if (hihgestSalaryProgrammer == null) {
            throw new NoJavaProgrammerFoundException("No Java programmer");
        }
        return hihgestSalaryProgrammer;
    }

    public Integer calculateChances(String name, String place, Woman woman) {
        Integer chance = 0;

        try {
            switch (place.toLowerCase()) {
                case "restaurant":
                    chance += 10;
                case "cinema":
                    chance += 20;
                case "walk":
                    chance += 5;
            }

            if (!woman.getFavPlace().equalsIgnoreCase(place)) {
                throw new BadPlaceForDateException("She does not like this place!");
            }

            switch (woman.getBreastSize()) {
                case A:
                    chance += BreastSize.A.getPoints();
                case B:
                    chance += BreastSize.B.getPoints();
                case C:
                    chance += BreastSize.C.getPoints();
                case D:
                    chance += BreastSize.D.getPoints();
            }

            chance += (int) (woman.getIq() / 10.0);

            if (chance > 100) {
                throw new OverConfidentException("Too confident!");
            }

        } catch (OverConfidentException e) {
            System.out.println(e.getMessage());
            chance = 30;
        } catch (BadPlaceForDateException e) {
            System.out.println(e.getMessage());
            chance = 0;
        }

        return chance;
    }

}
