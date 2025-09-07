package basics.o16.interfejsy.tasks.misie;

public interface Bear {
    void sayHi();
    default void roar(){
        System.out.println("Grrrrr!!!");
    }

}
