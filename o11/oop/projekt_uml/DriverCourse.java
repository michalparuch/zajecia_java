package basics.o11.oop.projekt_uml;

import java.time.LocalDate;

public class DriverCourse {
    private Course course;
    private LocalDate date;
    private String driverNote;
    private Driver driver;
    // TODO jaki kierowca jaki kurs

    public DriverCourse(Course course, LocalDate date, String driverNote, Driver driver) {
        this.course = course;
        this.date = date;
        this.driverNote = driverNote;
        this.driver = driver;

        // tu wywolasz metody ktore dodaja w driverze i w course do odpowiednich list
        addToDriverAndCourse();
    }

    public Course getCourse() {
        return course;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDriverNote() {
        return driverNote;
    }

    public void addToDriverAndCourse(){
        driver.getDriverCourses().add(this);
        course.getDriverCourse().add(this);
    }
}
