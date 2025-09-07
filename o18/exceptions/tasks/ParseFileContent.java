package basics.o18.exceptions.tasks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.IllegalFormatException;
import java.util.Scanner;

public class ParseFileContent {
    public static void parseFile() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj nazwe pliku: ");

        try {
            BufferedReader br = new BufferedReader(new FileReader(sc.nextLine()));

            String line;
            while ((line = br.readLine()) != null) {
                int number = Integer.parseInt(line.trim());
                System.out.println("Number read: " + number);

            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error " + e.getMessage());
        }


    }
}
