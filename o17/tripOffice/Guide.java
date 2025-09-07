package basics.o17.tripOffice;

import java.io.Serializable;
import java.util.*;

public class Guide extends Employee implements Serializable {
    private Set<Language> languageList;
    private EmploymentType employmentType;
    private String agreementType;
    private List<Trip> guideTrips;

    public Guide(String name, String phoneNumber, String email, String surname, Double salary, Double minSalary) {
        super(name, phoneNumber, email, surname, salary, minSalary);
        this.languageList = new HashSet<>();
        this.employmentType = EmploymentType.NORMAL_EMPLOYEE;
        this.guideTrips = new ArrayList<>();
        extension.add(this);
    }

    public Guide(String name, String phoneNumber, String email, String surname, Double salary, Double minSalary, EmploymentType employmentType, String agreementType) {
        super(name, phoneNumber, email, surname, salary, minSalary);
        this.employmentType = employmentType;
        this.agreementType = agreementType;
        this.languageList = new HashSet<>();
        extension.add(this);
    }

    public void addLanguage(Language language) {
        languageList.add(language);
    }

    public Set<Language> getLanguageList() {
        return languageList;
    }

    public void setLanguageList(Set<Language> languageList) {
        this.languageList = languageList;
    }

    public void addGuideTrips(Trip trip) {
        guideTrips.add(trip);
    }
}
