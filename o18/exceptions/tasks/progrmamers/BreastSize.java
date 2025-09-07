package basics.o18.exceptions.tasks.progrmamers;

public enum BreastSize {
    A(10),
    B(20),
    C(30),
    D(40);

    private final Integer points;

    BreastSize(Integer points) {
        this.points = points;
    }

    public Integer getPoints() {
        return points;
    }

}
