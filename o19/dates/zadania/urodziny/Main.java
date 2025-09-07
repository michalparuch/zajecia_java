package basics.o19.dates.zadania.urodziny;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Poproś program aby zapytal Cię o datę Twojego urodzenia
        //- jeśli podałeś datę późniejszą niż dziś to niech program rzuci
        //   błędem: InvalidBirthDateException
        //- program wypisuje ile dni żyjesz już
        //- program wypisuje ile już miesiecy żyjesz
        //- program wypisuje już ile lat żyjesz
        //- program wypisuje w który dzień tygodnia się urodziłeś

        try {
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");

            Scanner sc = new Scanner(System.in);
            System.out.println("Podaj date urodzenia");
            String date = sc.nextLine();
            LocalDate birthDate = LocalDate.parse(date, format);
            LocalDate now = LocalDate.now();

            if (birthDate.isAfter(now)) {
                throw new InvalidBirthDateException("Invalid date");
            }

            Long days = ChronoUnit.DAYS.between(birthDate, now);
            Long months = ChronoUnit.MONTHS.between(birthDate, now);
            Long years = ChronoUnit.YEARS.between(birthDate, now);
            DayOfWeek dayOfWeek = birthDate.getDayOfWeek();


            System.out.println("Days: " + days + " Months " + months + " Years " + years + " Day of week " + dayOfWeek);
        } catch (InvalidBirthDateException e) {
            System.out.println(e.getMessage());
        }


    }
}
