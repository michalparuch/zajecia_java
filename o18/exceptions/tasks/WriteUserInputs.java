package basics.o18.exceptions.tasks;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteUserInputs {
    public static void getAndWriteInputs() throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Podaj nazwe pliku:");

        String fileName = sc.nextLine();

        File file = new File(fileName);
        if (!file.exists()) {
            throw new IOException("Error");
        }

        try {
            FileWriter fw = new FileWriter(file, true);

            System.out.println("Podaj imie:");
            fw.write(sc.nextLine());

            System.out.println("Podaj nazwisko");
            fw.write(sc.nextLine());

            fw.close();

        } catch (IOException e) {
            System.out.println("File does not exist" + e.getMessage());
        }
    }
}
