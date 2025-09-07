package basics.o16.interfejsy;

public interface MyInterface {

    // Metody domyslne mogą mieć własciwą implementację w ciele interefjsu
    // słowo default przed

    // Publiczna metoda domyślna
    default void publicDefaultMethod() {
        System.out.println("This is a public default method.");
        privateHelperMethod();
    }

    /*
     *Cechy metod domyślnych:
     *Są częścią instancji klasy: Metody domyślne są wywoływane na instancjach klas, które implementują interfejs.
     *Mogą być nadpisywane: Klasa implementująca interfejs może nadpisać metodę domyślną, dostarczając własną implementację.
     *Mają dostęp do instancji obiektu: Mogą korzystać z pól i metod instancji klasy, która je implementuje.
     */

    // Statyczna metoda publiczna
    static void publicStaticMethod() {
        System.out.println("This is a public static method.");
        privateStaticHelperMethod();
    }

    /*
     *Cechy metod statycznych:
     *Należą do interfejsu: Nie można ich wywołać na instancji klasy implementującej interfejs, ale bezpośrednio na interfejsie.
     *Nie mogą być nadpisywane: Klasy implementujące interfejs nie mogą nadpisywać metod statycznych.
     *Nie mają dostępu do instancji obiektu: Metody statyczne nie mają dostępu do pól i metod instancji.
     */

    // Metody prywatne, w odronieniu od pozostalych, moga byc wywolane wylacznie w definicji interfejsu
    // Metody prywatne w interfejsach pozwalaja na usuniecie kodu, ktory powtarza sie w wielu miejscach.
    // Ten powtarzajacy sie kod jest wowczas zawarty w ciele metody prywatnej.

    // Prywatna metoda
    private void privateHelperMethod() {
        System.out.println("This is a private helper method.");
    }

    // Prywatna metoda statyczna
    private static void privateStaticHelperMethod() {
        System.out.println("This is a private static helper method.");
    }

}
