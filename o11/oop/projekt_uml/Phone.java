package basics.o11.oop.projekt_uml;

public class Phone extends Product{
    private String model;

    public Phone(String name, String category, String price, String model) {
        super(name, category, price);
        this.model = model;
    }

    public String getModel() {
        return model;
    }
}
