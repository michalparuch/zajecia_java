package basics.o11.oop.przyklady.asocjacja.z.atrybutem;

public class Main {

    public static void main(String[] args) {


        // Asocjacja z atrybutem jest koncepcją związaną z modelem obiektowym,
        // która opisuje związek pomiędzy dwoma lub więcej klasami, przy czym asocjacja
        // ta posiada dodatkowy atrybut lub właściwość, która charakteryzuje ten związek.
        // W kontekście Javy, asocjacja z atrybutem może być zaimplementowana za pomocą klas i ich właściwości.

        Car car = new Car("BMW");
        Garage garage = new Garage("NFS");

        CarRepair carRepair = new CarRepair("01/01/2024", 200.0, car, garage);

        garage.showRepairs();
    }

}
