package basics.o16.interfejsy;

public class Main {
    public static void main(String[] args) {

                /*
        Interfejs w Javie to zbiór abstrakcyjnych metod, które mogą być implementowane przez klasy.
        - Od Java 8 interfejsy mogą zawierać metody domyślne (default) oraz statyczne (static).
        - Od Java 9 można dodawać również metody prywatne (private) do interfejsów.
        - Interfejs definiuje co klasa powinna robić, ale nie jak to robić.
         */

        MyClass myClass = new MyClass();
        myClass.useMethods();

    }
}
