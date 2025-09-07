package basics.o18.exceptions;

public class MyUncheckedException extends RuntimeException {

    public MyUncheckedException(String message) {
        super(message);
    }

    public MyUncheckedException(Throwable cause) {
        super(cause);
    }
}
