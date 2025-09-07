package basics.o15.enumy.koszule;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Shirt s1 = new Shirt("wolczanka", "white", ShirtSize.L);

        System.out.println(s1.getSize());

        System.out.println(Arrays.toString(ShirtSize.values()));

        // indeks wartosci wyliczeniowej
        System.out.println(s1.getSize().ordinal());

        // valueOf pozwala uzyskac enuma ze Stringa, jesli taka wartosc enuma istnieje
        System.out.println(ShirtSize.valueOf("XL"));
    }
}
