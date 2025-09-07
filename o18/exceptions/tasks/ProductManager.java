package basics.o18.exceptions.tasks;

public class ProductManager {

    public static void checkProductCount(int count) {
        if (count < 1) {
            throw new InvalidProductCountException("Product count must be >= 1");
        }
        System.out.println("Correct, count: " + count);
    }

}
