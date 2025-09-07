package basics.o18.exceptions;

public class MyResource implements AutoCloseable{

    @Override
    public void close() {
        System.out.println("Resource has been closed.");
    }

    public void doSomething() {
        System.out.println("Performing an operation on the resource.");
    }

}
