package basics.o13.regex.pesel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {
    private String name, surname, pesel, sex, email;

    public Person(String name, String surname, String pesel, String sex, String email) {

        if (validateNameSurname(name) && validateNameSurnameUppercase(name)) {
            this.name = name;
        }

        if (validateNameSurname(surname) && validateNameSurnameUppercase(surname)) {
            this.surname = surname;
        }

        this.sex = sex;

        if (validateEmail(email)) {
            this.email = email;
        }

        if (validatePeselFormat(pesel) && validatePeselSex(pesel)) {
            this.pesel = pesel;
        }
    }

    public Boolean validatePeselFormat(String pesel) {

        Pattern peselPattern = Pattern.compile("\\d{11}");

        if (peselPattern.matcher(pesel).matches()) {
            return true;
        } else {
            throw new IllegalArgumentException("Wrong pesel format!");
        }
    }

    public Boolean validatePeselSex(String pesel) {

        if (sex.equalsIgnoreCase("female")) {
            Pattern peselPatter = Pattern.compile("([02468])$");
            return peselPatter.matcher(pesel).matches();
        } else if (sex.equalsIgnoreCase("male")) {
            Pattern peselPatter = Pattern.compile("([13579])$");
            return peselPatter.matcher(pesel).matches();
        } else {
            throw new IllegalArgumentException("Sex must be male or female!");
        }
    }

    public LocalDate getDateOfBirth(String pesel) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd");

        Pattern datePattern = Pattern.compile("\\d{6}");
        Matcher dateMatcher = datePattern.matcher(pesel);
        LocalDate date = null;

        if (dateMatcher.find()) {
            date = LocalDate.parse(dateMatcher.group(), formatter);
        }
        return date;
    }

    public Boolean validateNameSurname(String text) {
        Pattern textPattern = Pattern.compile("[A-Za-z]+");

        if (textPattern.matcher(text).matches()) {
            return true;
        } else {
            throw new IllegalArgumentException("Wrong name/surname format!");
        }
    }

    public Boolean validateNameSurnameUppercase(String text) {
        Pattern textPattern = Pattern.compile("[A-Z][a-z]+");

        if (textPattern.matcher(text).matches()) {
            return true;
        } else {
            throw new IllegalArgumentException("Wrong name/surname format!");
        }
    }

    public Boolean validateEmail(String email) {
        Pattern emailPattern = Pattern.compile("\\w+\\.*[a-z]*@[a-z]+\\.[a-z]+\\.?[a-z]+");

        if (emailPattern.matcher(email).matches()) {
            return true;
        } else {
            throw new IllegalArgumentException("Wrong email format!");
        }
    }
}
