package basics.o16.interfejsy.animals;

public class Cat implements Mammal {

    @Override
    public void makeSound() {
        System.out.println("Meow");
    }

    @Override
    public void sleep() {
        System.out.println("Cat is sleeping");
    }

    @Override
    public void feedBaby() {
        System.out.println("Cat is feeding baby");
    }

    @Override
    public String toString() {
        return "Cat";
    }

}
