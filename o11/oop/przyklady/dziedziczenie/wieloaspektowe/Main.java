package basics.o11.oop.przyklady.dziedziczenie.wieloaspektowe;

public class Main {

    public static void main(String[] args) {

        Lorry l1 = new Lorry("XF", "DAF", "Type 1", 2020, 6000);
        Lorry l2 = new Lorry("XF", "DAF", 2020, 95, 6000);

        System.out.println(l1);
        System.out.println(l2);
    }

}
