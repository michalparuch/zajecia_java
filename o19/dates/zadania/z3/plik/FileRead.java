package basics.o19.dates.zadania.z3.plik;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FileRead {

    public static void multiplyNumbers(String readFile, String writeFile) {

        try (BufferedReader br = new BufferedReader(new FileReader(readFile))) {
            try (FileWriter fw = new FileWriter(writeFile)) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

                LocalDateTime start = LocalDateTime.now();
                fw.write("Start: " + start.format(formatter) + "\n");

                String line;
                Pattern patter = Pattern.compile("\\d{100}");
                BigInteger sum = BigInteger.ZERO;

                while ((line = br.readLine()) != null) {
                    Matcher matcher = patter.matcher(line);
                    while (matcher.find()) {
                        BigInteger num = new BigInteger(matcher.group());

                        if (sum.equals(BigInteger.ZERO)) {
                            sum = sum.add(num);
                        } else {
                            sum = sum.multiply(num);
                        }
                    }
                }

                fw.write(String.valueOf(sum) + "\n");

                LocalDateTime end = LocalDateTime.now();
                fw.write("End: " + end.format(formatter) + "\n");

                Long totalTime = Duration.between(start, end).toMillis();

                fw.write("Total time (ms): " + totalTime);

                fw.close();


            } catch (IOException e) {
                System.out.println("FW issue" + e.getMessage());
            }
        } catch (IOException e) {
            System.out.println("FW issue" + e.getMessage());
        }
    }
}
