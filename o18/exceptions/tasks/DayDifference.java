package basics.o18.exceptions.tasks;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

public class DayDifference {
    public static long dateDifference(List<LocalDate> dates) {
        try {
            if (dates.isEmpty()) {
                throw new IllegalArgumentException("List is empty!");
            }
//            if (dates.contains(null)) {
//                throw new NullPointerException("List contains null!");
//            }

            LocalDate first = dates.getFirst();
            LocalDate last = dates.getLast();

            return last.toEpochDay() - first.toEpochDay();

        } catch (IllegalArgumentException | NullPointerException | NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return 0;
    }
}
