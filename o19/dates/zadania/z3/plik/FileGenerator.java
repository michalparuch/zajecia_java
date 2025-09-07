package basics.o19.dates.zadania.z3.plik;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class FileGenerator {

    public static void generateFile(String file) {
        try (FileWriter fw = new FileWriter(file)) {
            Random random = new Random();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

            for (int i = 0; i < 100; i++) {
                StringBuilder sb = new StringBuilder();
                Integer firstNum = random.nextInt(1, 10);
                sb.append(firstNum);

                for (int j = 0; j < 99; j++) {
                    Integer num = random.nextInt(10);
                    sb.append(num);
                }

                fw.write(LocalDateTime.now().format(formatter) + " " + sb + "\n");
            }


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
