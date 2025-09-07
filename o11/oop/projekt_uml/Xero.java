package basics.o11.oop.projekt_uml;

public class Xero extends Product implements Combo{
    private Integer weight;
    private String warranty;

    public Xero(String name, String category, String price, Integer weight) {
        super(name, category, price);
        this.weight = weight;
    }

    public Integer getWeight() {
        return weight;
    }

    @Override
    public String getWarranty(){
        return warranty;
    }
}
