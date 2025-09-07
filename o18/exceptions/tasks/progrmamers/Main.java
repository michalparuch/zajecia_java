package basics.o18.exceptions.tasks.progrmamers;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        /*
         * Stworz krotki system do zarzadzania programistami i ich partnerkami
         *
         * Programista ma imie, nazwisko, pensje oraz lsite jezykow jakie zna
         *
         * Kobieta ma imie, nazwsiko, rozmiar biustu oraz IQ
         *
         * Napisz metode ktora znajduje top n programistow (jesli chodzi o zarobki)
         * ktorzy kodza w javie. Jesli nie jestes w stanie tego zrobic rzuc wyjatkiem
         * NoJavaPorgrammerHere
         *
         * Programista moze chodzic na Randke(nazwa, miejsce, kobieta). Napisz metode
         * ktora wylicza % szanse na zaliczenie na randce. Algorytm zalezy odm iejsca np
         * restuaracja +10%, kino +20% itd oraz od kobiety, rozmiar A + 10%, B+ 20% itd
         * oraz od IQ wzor IQ/1000. Jesli szansa na zaliczenie wynosi over 100%
         * programista jest zapewny siebie i jego szanse spdaja, zatem obslugujemy
         * wyajtek i ustawiamy szanse na zaliczenie do 30%
         *
         * Dodaj kobiecie atrybut ulubione miejsce, ktore jest losowane z listy miejsc.
         * Jesli wylosowane ulubione miejsce kobiety jest inne niz to w ktorym zabral je
         * programista powstaje konflikt, BadPlaceForDateException z zastrzezeniem ze
         * moze przyjac on wiadomosc dla programisty od kobiety albo zostac pusty
         */

        Programmer p1 = new Programmer("Adam", "Nowak", 15000.0);
        Programmer p2 = new Programmer("Jan", "Kowalski", 12000.0);
        Programmer p3 = new Programmer("Adam", "Adamski", 20000.0);

        p1.setProgrammingLanguages(Arrays.asList("Java", "Python"));
        p2.setProgrammingLanguages(Arrays.asList("C++", "C#"));
        p3.setProgrammingLanguages(Arrays.asList("Java", "JavaScript"));


        Woman w1 = new Woman("Anna", "Kowalska", BreastSize.C, 120);
        System.out.println("w1 " + w1.getFavPlace());
        Woman w2 = new Woman("Joanna", "Kowalska", BreastSize.C, 140);
        System.out.println("w2 " + w1.getFavPlace());
        Woman w3 = new Woman("Kamila", "Kowalska", BreastSize.D, 80);
        System.out.println("w3 " + w1.getFavPlace());


        try {
            Programmer bestJavaDev = p1.programmerWithHighestSalary();
            System.out.println("Highest salary dev: " + bestJavaDev.getName() +
                    " " + bestJavaDev.getSurname() + " " + bestJavaDev.getSalary());
        } catch (NoJavaProgrammerFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("------");

        int chance1 = p1.calculateChances("Test1", "Cinema", w1);
        System.out.println("Chances test1: " + chance1);

        int chance2 = p1.calculateChances("Test2", "Restaurant", w2);
        System.out.println("Chances test2: " + chance2);

        int chance3 = p1.calculateChances("Test3", "Walk", w3);
        System.out.println("Chances test3: " + chance3);
    }
}
