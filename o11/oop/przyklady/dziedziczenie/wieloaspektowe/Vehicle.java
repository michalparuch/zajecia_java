package basics.o11.oop.przyklady.dziedziczenie.wieloaspektowe;

public abstract class Vehicle {

    private String model;
    private String brand;
    private String typeOfDpf; // pole opcjonalne - obowiazkowe dla pojazdu diesla
    private int productionYear;
    private int octaneNumber; // pole opcjonalne - obowiazkowe dla pojazdu z silnikiem benzynowym

    public Vehicle(String model, String brand, String typeOfDpf, int productionYear) {
        this.model = model;
        this.brand = brand;
        this.typeOfDpf = typeOfDpf;
        this.productionYear = productionYear;
    }

    public Vehicle(String model, String brand, int productionYear, int octaneNumber) {
        this.model = model;
        this.brand = brand;
        this.productionYear = productionYear;
        this.octaneNumber = octaneNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getTypeOfDpf() {
        return typeOfDpf;
    }

    public void setTypeOfDpf(String typeOfDpf) {
        this.typeOfDpf = typeOfDpf;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public int getOctaneNumber() {
        return octaneNumber;
    }

    public void setOctaneNumber(int octaneNumber) {
        this.octaneNumber = octaneNumber;
    }

}
