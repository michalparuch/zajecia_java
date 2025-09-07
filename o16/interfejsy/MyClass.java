package basics.o16.interfejsy;

public class MyClass implements MyInterface {

    public void useMethods() {
        publicDefaultMethod();
        MyInterface.publicStaticMethod();
        // privateHelperMethod(); // To spowoduje błąd kompilacji, ponieważ metoda prywatna nie jest dostępna.
        // privateStaticHelperMethod(); // To również spowoduje błąd kompilacji.
    }

}
