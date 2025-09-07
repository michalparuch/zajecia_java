package basics.o15.enumy.dyplomy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Diplom {
    public static List<Diplom> extension = new ArrayList<>();

    private String name, surname;
    private LocalDate dateOfIssue;
    List<Grade> gradesList;

    public Diplom(String name, String surname, LocalDate dateOfIssue) {
        this.name = name;
        this.surname = surname;
        this.dateOfIssue = dateOfIssue;
        this.gradesList = new ArrayList<>();
        extension.add(this);
    }

    public Diplom getDiplomaWithHighestGPA() {
        Diplom bestDiploma = null;
        Double highestGPA = 0.00;

        for (Diplom dipl : extension) {
            int sumOfGrades = 0;
            for (Grade grade : dipl.gradesList) {
                sumOfGrades += grade.getFinalGrade();
            }
            double tempGPA = (double) sumOfGrades / dipl.gradesList.size();
            if (tempGPA > highestGPA) {
                highestGPA = tempGPA;
                bestDiploma = dipl;
            }

        }
        return bestDiploma;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
