package basics.o14.bignumbers.plik;

import java.io.*;
import java.math.BigInteger;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {

        //		stworz sobie jakis plik z liczbami, 100 liczb stucyfrowych (roznych, losowych!)
        //		Wczytaj te liczby z pliku i zapisz iloczyn tych liczb to pliku wynik.txt
        createBigIntFile();
        multiplyBigIntsInFile();

    }

    public static void createBigIntFile() throws IOException {
        FileWriter fw = new FileWriter("C:\\Users\\xmari\\IdeaProjects\\zajecia1\\src\\basics\\o14\\bignumbers\\plik\\dane.txt");

        for (int i = 0; i < 100; i++) {
            StringBuilder sb = new StringBuilder();

            Random random = new Random();
            sb.append(random.nextInt(1, 10));

            for (int j = 0; j < 99; j++) {
                sb.append(random.nextInt(10));
            }
            fw.write(String.valueOf(sb) + "\n");
        }

        fw.close();
    }

    public static void multiplyBigIntsInFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\xmari\\IdeaProjects\\zajecia1\\src\\basics\\o14\\bignumbers\\plik\\dane.txt"));

        String line;
        BigInteger output = BigInteger.ONE;

        while ((line = br.readLine()) != null) {
            line = line.trim();
            BigInteger tempNumber = new BigInteger(line);
            output = output.multiply(tempNumber);
        }

        FileWriter fw = new FileWriter("C:\\Users\\xmari\\IdeaProjects\\zajecia1\\src\\basics\\o14\\bignumbers\\plik\\wynik.txt");
        fw.write(String.valueOf(output));
        fw.close();
        br.close();
    }
}
