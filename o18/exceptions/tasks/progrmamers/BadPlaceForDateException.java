package basics.o18.exceptions.tasks.progrmamers;

public class BadPlaceForDateException extends RuntimeException {
    public BadPlaceForDateException() {
        super();
    }

    public BadPlaceForDateException(String message) {
        super(message);
    }

}
