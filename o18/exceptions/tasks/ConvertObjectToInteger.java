package basics.o18.exceptions.tasks;

import java.util.List;
import java.util.Objects;

public class ConvertObjectToInteger {
    public static void convertObject(List<Object> objects){
        try {
            for (Object object : objects){
                Integer value = (Integer) object;
                System.out.println(value);
            }
        } catch (ClassCastException e){
            System.out.println("Can't convert obj " + e.getMessage());
        }
    }
}
