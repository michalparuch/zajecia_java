package basics.o15.enumy.person;

import java.util.ArrayList;
import java.util.List;

public class PersonEnum {
    public static List<PersonEnum> extension = new ArrayList<>();

    private String name, surname;
    private HairColor hairColor;
    private EyesColor eyesColor;

    public PersonEnum(String name, String surname, HairColor hairColor, EyesColor eyesColor) {
        this.name = name;
        this.surname = surname;
        this.hairColor = hairColor;
        this.eyesColor = eyesColor;
        extension.add(this);
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public EyesColor getEyesColor() {
        return eyesColor;
    }

    public HairColor getHairColor() {
        return hairColor;
    }

    public List<PersonEnum> getPersonWithEyesColor(EyesColor searchedEyesColor) {
        List<PersonEnum> output = new ArrayList<>();
        for (PersonEnum person : extension) {
            if (person.eyesColor.equals(searchedEyesColor)) {
                output.add(person);
            }
        }
        return output;
    }

    public Integer getCountOfPersonWithHairColor(HairColor searchedHairColor) {
        Integer counter = 0;
        for (PersonEnum person : extension) {
            if (person.hairColor.equals(searchedHairColor)) {
                counter++;
            }
        }
        return counter;
    }

    public PersonEnum getPersonWithLongestSurname(EyesColor searchedEyesColor) {
        Integer longestSurnameLength = extension.getFirst().surname.length();
        PersonEnum personWithLongestSurname = extension.getFirst();

        for (PersonEnum person : extension) {
            if (person.eyesColor.equals(searchedEyesColor)) {
                if (person.getSurname().length() > longestSurnameLength) {
                    personWithLongestSurname = person;
                }
            }
        }
        return personWithLongestSurname;
    }

    @Override
    public String toString() {
        return "PersonEnum{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
