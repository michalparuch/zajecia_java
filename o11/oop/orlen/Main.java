package basics.o11.oop.orlen;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {


        // // Stworz model dla pracownikow Orlenu, tworzysz zmiany (1, 2, 3), kazda zmiana ma mistrza jednego oraz liste pracownikow
        //    // ale liczba nie mzoe byc wieksza niz 4 pracownikow + mistrz
        //    // Chcemy wiedziec, na jakiej zmianie praucje kazdy z praconikow oraz mistrz
        //    // Wypisz pracownikow na kazdej zmianie
        //    // Dodaj instalacje na ktorej pracuja, i zmiana istnieje tylko wtedy, gdy istnieje instalacja
        //
        //    // Pracownik ma swoja wydajnosc (0.6, 1, 0.88) i chcemy wiedziec jaka jest wydajnosc calej zmiany
        //    // Chcemy znalezc nabardziej wydajna zmiane z instalacji jednej oraz ze wszystkich
        //
        //    // pracownik ma PESEL, pesel musi byc unilany
        //    // dodaj jeszcze jakeis pola do pracownika
        //    // wiek, ale jezeli pracownik ma mniej niz 5 lat do emerytury, to ustawiamy mu flage zwolnienia na false
        //    // flagi nie ustawiamy jako parametr kosntruktora, tylko jako metoda w konstruktorze

        Employee emp1 = new Employee("1234567890", "Jan Kowalski_1", LocalDate.parse("1980-01-01"), 'M', 0.8);
        System.out.println(emp1.getCanBeFired());

        Employee emp2 = new Employee("1234567880", "Jan Kowalski_2", LocalDate.parse("1960-01-01"), 'M', 0.5);
        System.out.println(emp2.getCanBeFired());

        Employee emp3 = new Employee("1234567870", "Jan Kowalski_3", LocalDate.parse("1970-01-01"), 'F', 0.6);

        Employee emp4 = new Employee("1234567860", "Jan Kowalski_4", LocalDate.parse("1980-01-01"), 'F', 0.9);
        System.out.println(emp4.getCanBeFired());

        Employee emp5 = new Employee("1234567850", "Jan Kowalski_5", LocalDate.parse("1980-01-01"), 'M', 0.2);
        Employee emp6 = new Employee("1234567840", "Jan Kowalski_6", LocalDate.parse("1980-01-01"), 'M', 0.1);
        Employee emp7 = new Employee("1234567830", "Jan Kowalski_7", LocalDate.parse("1980-01-01"), 'M', 0.9);
        Employee emp8 = new Employee("1234567820", "Jan Kowalski_8", LocalDate.parse("1980-01-01"), 'M', 1.0);

        Instalation inst1 = new Instalation("Instalacja1");
        Instalation inst2 = new Instalation("Instalacja2");

        Shift shift1 = new Shift(1, inst1, emp1);
        Shift shift2 = new Shift(2, inst1, emp1);
        Shift shift3 = new Shift(3, inst2, emp2);

        shift3.addEmployee(emp3);
        shift3.addEmployee(emp4);
        shift3.addEmployee(emp7);
        shift3.addEmployee(emp8);

        shift1.addEmployee(emp3);
        shift1.addEmployee(emp4);
        shift1.addEmployee(emp5);
        shift1.addEmployee(emp6);
//        shift1.addEmployee(emp8);

        shift2.addEmployee(emp3);
        shift2.addEmployee(emp4);
        shift2.addEmployee(emp5);
        shift2.addEmployee(emp7);

        System.out.println("Shift1 efficency:");
        System.out.println(shift1.getShiftEfficiency());

        System.out.println("Shift2 efficency:");
        System.out.println(shift2.getShiftEfficiency());

        System.out.println("Shift3 efficency:");
        System.out.println(shift3.getShiftEfficiency());

        System.out.println(Shift.getBestShiftFromInstallation(inst1));

        System.out.println(Shift.getBestShift());


    }
}
