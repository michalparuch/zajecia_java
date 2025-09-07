package basics.o11.oop.przedszkole;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Group {
    private Integer maxKids = 15;
    String groupName;
    List<Children> childrens;
    private Teacher teacher;
    private Room room;

    public Group(String groupName) {
        this.groupName = groupName;
        this.childrens = new ArrayList<>();
    }

    public void addChildren(Children child) {
        // TODO wyciagnac 15 do zmiennej klasowej (private static int maxKids czyj akos tak)
        if (childrens.size() < maxKids) {
            childrens.add(child);
        } else {
            System.out.println("Group is full");
        }
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
        if (!teacher.getGroups().contains(this)) {
            teacher.addGroup(this);
        }
    }

    public List<Children> getChildrens() {
        return childrens;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Room getRoom() {
        return room;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public String getGroupName() {
        return groupName;
    }

    public static void getChildrenToFile(Teacher teacher) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\xmari\\IdeaProjects\\zajecia1\\src\\basics\\o11\\oop\\przedszkole\\Uczniowie.txt"))) {
            for (Group group : teacher.getGroups()) {
                for (Children child : group.getChildrens()) {
                    writer.write(child.getName() + " " + child.getSurname());
                    writer.newLine();
                }
            }
            System.out.println("Children saved to file");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
