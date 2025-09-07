package basics.o18.exceptions.tasks;

import java.util.List;
import java.util.Map;

public class ListElementsDivision {
    public static void listDivision(List<Integer> list1, List<Integer> list2) {


        for (int i = 0; i < Math.max(list1.size(), list2.size()); i++) {
            try {
                System.out.println(list1.get(i) / list2.get(i));
            } catch (ArithmeticException e){
                System.out.println("Division by zero at position " + i);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Index out of range");
            }

        }
    }

}
