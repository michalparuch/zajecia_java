package basics.o11.oop.przedszkole;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Teacher {
    private  static List<Teacher> extension = new ArrayList<>();

    private String name;
    private String surname;
    private String birthDate;
    private Integer baseSalary;

    private List<String> qualifications = new ArrayList<>();
    private List<Group> groups = new ArrayList<>();


    public Teacher(String name, String surname, String birthDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        extension.add(this);
    }

    public void addQualification(String qualification) {
        qualifications.add(qualification);
    }

    public void setBaseSalary(Integer baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Integer getFinalSalary() {
        if (qualifications.isEmpty()) {
            return (baseSalary);
        } else {
            return (baseSalary * 2);
        }
    }

    public void addGroup(Group group) {
        groups.add(group);
        if (group.getTeacher() != this) {
            group.setTeacher(this);
        }
    }

    public static List<Teacher> getTeachersWithHigherSalary(Integer salary){
        // TODO ograniczenie do kwalifikowanych
        List<Teacher> teachersWithHigherSalary= new ArrayList<>();

        for (Teacher teacher : extension){
            if(teacher.getFinalSalary() > salary && !teacher.qualifications.isEmpty()){
                teachersWithHigherSalary.add(teacher);
            }
        }
        return teachersWithHigherSalary;
    }

    public List<Group> getGroups() {
        return groups;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
