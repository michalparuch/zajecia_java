package basics.o11.oop.projekt_uml;

public class Printer extends Product implements Combo{
    private Integer printTimeSeconds;
    private String warranty;

    public Printer(String name, String category, String price, Integer printTimeSeconds) {
        super(name, category, price);
        this.printTimeSeconds = printTimeSeconds;
    }

    public Integer getPrintTimeSeconds() {
        return printTimeSeconds;
    }

    @Override
    public String getWarranty(){
        return warranty;
    }
}
