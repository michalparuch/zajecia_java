package basics.o16.interfejsy.animals;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();

        List<Animal> animals = List.of(dog, cat);

        for (Animal animal : animals) {
            animal.makeSound();
            animal.sleep();
            feed(animal);
        }

        cat.feedBaby();
        System.out.println(cat.NUMBER_OF_PAWS);
    }

    public static void feed(Animal animal) {
        System.out.println("Feeding " + animal.toString());
    }

}
