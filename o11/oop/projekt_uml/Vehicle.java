package basics.o11.oop.projekt_uml;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Vehicle {
    private String brand;
    private String model;
    private Integer productionYear;
    private String octane;
    private String dpfBrand;



    public Vehicle(String brand, Integer productionYear, String model, String octane) {
        this.brand = brand;
        this.productionYear = productionYear;
        this.model = model;
        this.octane = octane;
    }

    public Vehicle(String brand, String model, Integer productionYear, String dpfBrand) {
        this.brand = brand;
        this.model = model;
        this.productionYear = productionYear;
        this.dpfBrand = dpfBrand;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setProductionYear(Integer productionYear) {
        this.productionYear = productionYear;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(brand, vehicle.brand) && Objects.equals(model, vehicle.model) && Objects.equals(productionYear, vehicle.productionYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, productionYear);
    }
}
