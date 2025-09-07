package basics.o13.regex.pesel;

public class Main {
    public static void main(String[] args) {

        /*
         * Stworz klase Osoba(imie,nazwisko, pesel, plec, email)
         *
         * 1) Sprawdz czy pesel jest poprawny - czy sklada sie z 11 znakow, samych cyfr itp
         *
         *
         * 2) Sprawdz czy pesel odpowiada podanej płci
         *
         * 3) Napisz metody które zwracaja z peselu date urodzenia (LocalDAte)
         *
         * 4) Sprawdź, czy imię i nazwisko zawierają tylko litery:
         *
         * 5) Sprawdź, czy pierwsza litera imienia i nazwiska jest wielka:
         *
         * 6) Weryfikuj adresy e-mail:
         *
         * 7) Wyciagnij date urodzenia z peselu ------> bylo w poleceni 3)!
         */
        Person person1 = new Person("Jan", "Kowalski", "12312312311", "male", "jan@gmail.com"); //true
//        Person person2 = new Person("Jan", "Kowalski", "12312312311", "male", "jangmail.com"); //false
//        Person person3 = new Person("jan", "Kowalski", "12312312311", "male", "jan@gmail.com"); //false
//        Person person4 = new Person("1an", "Kowalski", "12312312311", "male", "jan@gmail.com"); //false
//        Person person4 = new Person("Jan", "Kowalski", "1312312311", "male", "jan@gmail.com"); //false
//        Person person4 = new Person("Jan", "Kowalski", "12312312311", "test", "jan@gmail.com"); //false

    }
}
