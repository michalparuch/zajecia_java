package basics.o18.exceptions.tasks;

import java.util.*;

public class RandomListElement {
    private List<String> listOfWords = new ArrayList<>(Arrays.asList("Test", "Test2", "Test3"));

    public Integer getRandomIndex() {
        Random random = new Random();
        return random.nextInt(6);
    }

    public void readElementByRandomIndex() {
        try {
            System.out.println(listOfWords.get(getRandomIndex()));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Indeks poza zakresem" + " " + e.getMessage());
        }
    }
}
