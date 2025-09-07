package basics.o11.oop.przyklady.overlapping;

import java.util.EnumSet;

public class Training {
    enum Subclass {TECHNICAL_TRAINING, DIVING_TRAINING}

    private String name, description, style;
    private Integer minimumTimeUnderwater;
    private Subclass subclass;
    private EnumSet<Subclass> subclasses;

    public Training(String name, String description, String style) {
        this.name = name;
        this.description = description;
        this.style = style;
        this.minimumTimeUnderwater = null;
        this.subclasses = EnumSet.of(Subclass.TECHNICAL_TRAINING);
    }

    public Training(String name, String description, Integer minimumTimeUnderWater) {
        this.name = name;
        this.description = description;
        this.style = null;
        this.minimumTimeUnderwater = minimumTimeUnderWater;
        this.subclasses = EnumSet.of(Subclass.DIVING_TRAINING);
    }

    public Training(String name, String description, String style, Integer minimumTimeUnderWater) {
        this.name = name;
        this.description = description;
        this.style = style;
        this.minimumTimeUnderwater = minimumTimeUnderWater;
        this.subclasses = EnumSet.of(Subclass.TECHNICAL_TRAINING, Subclass.DIVING_TRAINING);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Training: ").append(name).append("\n");
        sb.append("Description: ").append(description).append("\n");

        if (subclasses.contains(Subclass.TECHNICAL_TRAINING) && subclasses.contains(Subclass.DIVING_TRAINING)) {
            sb.append("Type: Technical and Diving Training\n");
        } else if (subclasses.contains(Subclass.TECHNICAL_TRAINING)) {
            sb.append("Type: Technical Training\n");
        } else if (subclasses.contains(Subclass.DIVING_TRAINING)) {
            sb.append("Type: Diving Training\n");
        } else {
            sb.append("Type: Training\n");
        }

        if (style != null) {
            sb.append("Style: ").append(style).append("\n");
        }

        if (minimumTimeUnderwater != null) {
            sb.append("Minimum Time Under Water: ").append(minimumTimeUnderwater).append("\n");
        }

        return sb.toString();
    }
}
