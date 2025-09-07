package basics.o11.oop.basics;

import java.util.Objects;

public class Engine {

    private final int capacity;

    public Engine(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "capacity=" + capacity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Engine engine = (Engine) o;
        return capacity == engine.capacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(capacity);
    }

}
