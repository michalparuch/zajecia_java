package basics.o18.exceptions.tasks;

import java.time.DayOfWeek;

public class ConvertDateToEnum {

    public static DayOfWeek convertToDayOfWeek(String day) {
        try {
            return DayOfWeek.valueOf(day.toUpperCase());
        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println("Incorrect date format " + e.getMessage());
            return null;
        }
    }

}
