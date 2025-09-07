package basics.o11.oop.projekt_uml;

public class CoursePart {
    // TODO kompozycja z Course
    private double distance;
    private int estimatedTimeMinutes;
    private Course course;

    public CoursePart(double distance, int estimatedTimeMinutes, Course course) {
        this.distance = distance;
        this.estimatedTimeMinutes = estimatedTimeMinutes;
        this.course = course;
        addPartToCourse();
    }

    public double getDistance() {
        return distance;
    }

    public int getEstimatedTimeMinutes() {
        return estimatedTimeMinutes;
    }

    public void addPartToCourse(){
        course.getParts().add(this);
    }

}
