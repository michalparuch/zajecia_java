package basics.o18.exceptions.tasks;

public class InvalidProductCountException extends RuntimeException {
    public InvalidProductCountException(String message) {
        super(message);
    }
}
