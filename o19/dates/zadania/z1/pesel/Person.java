package basics.o19.dates.zadania.z1.pesel;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Person {
    private String name;
    private String surname;
    private String pesel;

    public Person(String name, String surname, String pesel) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
    }

    public LocalDate getDateOfBirth() {
        Integer year = Integer.parseInt(pesel.substring(0, 2));
        Integer month = Integer.parseInt(pesel.substring(2, 4));
        Integer day = Integer.parseInt(pesel.substring(4, 6));

        if (year < 10) {
            year += 2000;
        } else {
            year += 1900;
        }

//        String birthDate = day + "-" + month + "-" + year;
//        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yy");
//
//        return LocalDate.parse(birthDate, format);

        return LocalDate.of(year, month, day);

    }

    public int getPersonAge() {
        System.out.println(Period.between(getDateOfBirth(), LocalDate.now()).getYears());
        return Period.between(getDateOfBirth(), LocalDate.now()).getYears();
    }

    public void enterLocal(Local local) {
        if (local.getMinAge() > getPersonAge()) {
            throw new jestesZaMlodyZiom("You are too young");
        }
        System.out.println("You are entering " + local.getName());
    }
}
