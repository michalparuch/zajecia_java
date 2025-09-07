package basics.o11.oop.przedszkole;

import java.util.ArrayList;
import java.util.List;

public class Children {
    private static List<Children> extension = new ArrayList<>();

    private String name;
    private String surname;
    private String birthDate;

    private List<String> notices = new ArrayList<>();

    public Children(String name, String surname, String birthDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        extension.add(this);
    }

    public void addNotice(String notice) {
        notices.add(notice);
    }

    public Boolean odznaka() {
        if (notices.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public List<String> getNotices() {
        return notices;
    }

    public static Children getChildrenWithMostNotices() {
        Children worstChild = extension.getFirst();

        for (Children children : extension) {
            if (children.getNotices().size() > worstChild.getNotices().size()) {
                worstChild = children;
            }
        }
        return worstChild;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Children{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
