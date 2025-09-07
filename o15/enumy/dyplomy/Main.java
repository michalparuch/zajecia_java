package basics.o15.enumy.dyplomy;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        // Stworz klase Dyplom ktora posiada imie i nazwisko, date wystawienia, na
        // dyplomie znajduja sie oceny z przedmiotow(lista klasy Ocena, gdzie ocena ma wartosc i nazwe przedmiotu)
        // stworz kilka dyplomow, znajdz dyplom z najwieksza srednia


        Diplom d1 = new Diplom("Anna", "Nowak", LocalDate.of(2022, 6, 30));
        d1.gradesList.add(new Grade(Subjects.HISTORY, 5));
        d1.gradesList.add(new Grade(Subjects.ART, 4));
        d1.gradesList.add(new Grade(Subjects.BIOLOGY, 5));


        Diplom d2 = new Diplom("Jan", "Kowalski", LocalDate.of(2022, 6, 30));
        d2.gradesList.add(new Grade(Subjects.HISTORY, 3));
        d2.gradesList.add(new Grade(Subjects.ART, 3));
        d2.gradesList.add(new Grade(Subjects.BIOLOGY, 4));

        Diplom d3 = new Diplom("Ewa", "Zielińska", LocalDate.of(2022, 6, 30));
        d3.gradesList.add(new Grade(Subjects.CHEMISTRY, 6));
        d3.gradesList.add(new Grade(Subjects.GEOGRAPHY, 5));
        d3.gradesList.add(new Grade(Subjects.BIOLOGY, 6));


        Diplom best = d1.getDiplomaWithHighestGPA();

        if (best != null) {
            System.out.println("Najlepszy dyplom należy do: " + best.getName() + " " + best.getSurname());
        } else {
            System.out.println("Brak dyplomów.");
        }
    }
}
