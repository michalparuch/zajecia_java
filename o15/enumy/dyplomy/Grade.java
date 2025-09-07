package basics.o15.enumy.dyplomy;

public class Grade {
    Subjects subject;
    Integer finalGrade;

    public Grade(Subjects subject, Integer finalGrade) {
        this.subject = subject;
        this.finalGrade = finalGrade;
    }

    public Subjects getSubject() {
        return subject;
    }

    public Integer getFinalGrade() {
        return finalGrade;
    }
}
