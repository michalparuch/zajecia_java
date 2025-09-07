package basics.o17.tripOffice;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class InfoCard implements Serializable {
    public static List<InfoCard> extension = new ArrayList<>();

    private static Integer count = 0;

    private String tripDescription;
    private Integer minAge;
    private String additionalInfo;

    public InfoCard(String tripDescription, Integer minAge, String additionalInfo) {
        this.tripDescription = tripDescription;
        this.minAge = minAge;
        this.additionalInfo = additionalInfo;
        extension.add(this);
    }

    public static Integer getCount() {
        return count;
    }

    public String getTripDescription() {
        return tripDescription;
    }

    public Integer getMinAge() {
        return minAge;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setTripDescription(String tripDescription) {
        this.tripDescription = tripDescription;
    }

    public static void setCount(Integer count) {
        InfoCard.count = count;
    }

    public void setMinAge(Integer minAge) {
        this.minAge = minAge;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
}
