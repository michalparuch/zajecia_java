package basics.o16.interfejsy.animals;

public class Dog implements Animal {

    @Override
    public void makeSound() {
        System.out.println("Bark");
    }

    @Override
    public void sleep() {
        System.out.println("Dog is sleeping");
    }

    @Override
    public String toString() {
        return "Dog";
    }

}
