package basics.o17.tripOffice.serializacja;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Person p1 = new Person("Jan", "Kowalski");
        Person p2 = new Person("Marek", "Nowak");
        List<Person> persons = List.of(p1, p2);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("persons.ser"))) {
            oos.writeObject(persons);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<Person> newList = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("persons.ser"))) {
            newList.addAll((List<Person>) ois.readObject());
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println(newList);
    }
}
