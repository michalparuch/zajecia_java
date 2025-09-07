package basics.o11.oop.employees;

import basics.o11.oop.basics.Car;
import basics.o11.oop.basics.Engine;
import basics.o11.oop.clients.Product;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        		/*
		 * Stwórz klasę Pracownik (imie,nazwisko, adres, pensja) i Klient (imie,nazwisko, ulubiony produkt). Klient kupuje produkty (nazwa, cena).
			Pracownik uzywa samochod (model, marka)

			1) Znajdz klienta który wydal najwiecej

			2) Wyswietl dla kazdego klienta jego ulubiony produkt (of cuz ulubiony produkt to ma byc atrybut wyliczalny na podstawie zakupow)

			3) Wyswietl 3 top pracownikow z najwieksza pensja (compartor + sortowanie) DODATKOWE

			4) Pracownicy auta moga uzywac wielkorotnie, chcemy przechowywac informacje (i moc ja wyswietlic) ile jaki pracownik uzywal jakiego auta
		 */

        Client client1 = new Client("Jan", "Kowalski");
        Client client2 = new Client("Stefan", "Stefanski");
        Client client3 = new Client("Pawel", "Pawlowski");

        client1.addProduct(new Product("Jajko", 10));
        client1.addProduct(new Product("Mieso", 20));
        client1.addProduct(new Product("Telefon", 100));

        client2.addProduct(new Product("Telefon", 100));
        client2.addProduct(new Product("Mieso", 20));
        client2.addProduct(new Product("Telefon", 100));

        client3.addProduct(new Product("Jajko", 10));
        client3.addProduct(new Product("Jajko", 10));
        client3.addProduct(new Product("Telefon", 100));


        //1) Znajdz klienta który wydal najwiecej
        System.out.println(Client.getClientWhoSpendTheMost());

        //2) Wyswietl dla kazdego klienta jego ulubiony produkt (of cuz ulubiony produkt to ma byc atrybut wyliczalny na podstawie zakupow)
        System.out.println(client2.getFavProduct());
        System.out.println(client3.getFavProduct());

        //3) Wyswietl 3 top pracownikow z najwieksza pensja (compartor + sortowanie) DODATKOWE
        Employee emp1 = new Employee("Jan", "Kowalski_1", "Warszawa", 1000);
        Employee emp2 = new Employee("Jan", "Kowalski_2", "Warszawa", 10000);
        Employee emp3 = new Employee("Jan", "Kowalski_3", "Warszawa", 1000);
        Employee emp4 = new Employee("Jan", "Kowalski_4", "Warszawa", 15000);
        Employee emp5 = new Employee("Jan", "Kowalski_5", "Warszawa", 2000);
        Employee emp6 = new Employee("Jan", "Kowalski_6", "Warszawa", 1000);
        for (Employee employee:Employee.getTop3()){
            System.out.println(employee);
        }

        //4) Pracownicy auta moga uzywac wielkorotnie, chcemy przechowywac informacje (i moc ja wyswietlic) ile jaki pracownik uzywal jakiego auta
        emp1.useCar(new Car("Acura","Tundra",2023,"Premium", new Engine(2993), 100000, "red", 4000));
        emp1.useCar(new Car("Acura","Tundra",2023,"Premium", new Engine(2993), 100000, "red", 4000));
        emp1.useCar(new Car("Acura","Tundra",2023,"Premium", new Engine(2993), 100000, "red", 4000));

        emp1.useCar(new Car("Toyota","Supra",2023,"Premium", new Engine(2993), 100000, "red", 4000));

        emp2.useCar(new Car("BMW","Z3",2023,"Premium", new Engine(2993), 100000, "red", 4000));
        emp2.useCar(new Car("BMW","Z3",2023,"Premium", new Engine(2993), 100000, "red", 4000));


        System.out.println(emp1.getCars());
        System.out.println(emp2.getCars());

    }
}
