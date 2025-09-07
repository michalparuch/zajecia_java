package basics.o11.oop.orlen;

import java.util.Objects;

public class Instalation {
    private String name;

    public Instalation(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Instalation that = (Instalation) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return "Instalation{" +
                "name='" + name + '\'' +
                '}';
    }
}
