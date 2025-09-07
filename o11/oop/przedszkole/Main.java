package basics.o11.oop.przedszkole;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        /*
         * Stwórz system do zarządzania przedszkolem. W przedszkolu mamy dzieci oraz
         * wychowawcow, dla obu chcemy znac imie, nazwisko oraz date urodzenia. Dzieci
         * dziela sie na posluszne (odznaka) i nieposluszne (przewinienia).
         *
         * Wychowawcy maja pensje (obliczana za pomoca algorytmu) i dziela sie na
         * wychowawcow kwalifikowanych (kwalifikacje) oraz tymczasowych.
         *
         * Wychowacwa odpowiada za grupe (nazwa, max liczba dzieci, obecnie 15).
         * Wychowacwca moze miec wiele grup, grupa ma jednego wychowawce.
         *
         * Kazda grupa ma przypisana sale (nazwa, kolor scian).
         *
         * -napisz metode która zwraca dziecko ktore ma najwiecej przewinien
         * -napisz metode ktora zwroci wychowawcow kwliafikowanych z pensja wieksza niz podany parametr
         * -zapisz do pliku imiona nazwiska wszystkich dzieci którzy sa w grupie dla wychowawcy podanego jako parametr
         *
         */

        Room room1 = new Room("Sala 101", "czerwone");
        Room room2 = new Room("Sala 201", "Niebieskie");


        Children child1 = new Children("Jan", "Kowalski_1", "23.11.1998");
        Children child2 = new Children("Jan", "Kowalski_2", "23.11.1998");
        Children child3 = new Children("Jan", "Kowalski_3", "23.11.1998");

        Teacher teacher1 = new Teacher("Pawel", "Pawlowski_1", "11.01.1980");
        Teacher teacher2 = new Teacher("Pawel", "Pawlowski_2", "11.01.1980");
        Teacher teacher3 = new Teacher("Pawel", "Pawlowski_3", "11.01.1980");

        Group group1 = new Group("Grupa1");
        Group group2 = new Group("Grupa2");

        group1.addChildren(child1);
        group1.addChildren(child2);
        group2.addChildren(child3);

        group1.setTeacher(teacher1);
        group2.setTeacher(teacher2);

        child1.addNotice("Zle zachowanie 1");
        child1.addNotice("Zle zachowanie 2");
        child2.addNotice("Zle zachowanie 1");
        child2.addNotice("Zle zachowanie 2");
        child2.addNotice("Zle zachowanie 3");
        child3.addNotice("Zle zachowanie 1");


        teacher1.setBaseSalary(4000);
        teacher1.addQualification("Dyplom");
        teacher2.setBaseSalary(5000);
        teacher3.setBaseSalary(2000);

        System.out.println(Children.getChildrenWithMostNotices());
        System.out.println(Teacher.getTeachersWithHigherSalary(3000));

        Group.getChildrenToFile(teacher1);
    }
}
