package basics.o18.exceptions.tasks;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static basics.o18.exceptions.Main.readFile;

public class ReadFile {

    public void tryReadFile(String file) {
        try {
            readFile(file);
        } catch (IOException e) {
            System.out.println("File does not exists" + e.getMessage());
        } finally {
            createNewFile();
        }
    }

    public void createNewFile(){
        File file = new File("test.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
