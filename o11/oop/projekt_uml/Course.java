package basics.o11.oop.projekt_uml;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String name;
    private String location;
    private List<CoursePart> parts = new ArrayList<>();
    private List<Product> products = new ArrayList<>();
    private List<DriverCourse> driverCourse = new ArrayList<>();

    public Course(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public List<CoursePart> getParts() {
        return parts;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProductToCourse(Product product){
        if(products.size()>5){
            throw new IllegalArgumentException("This course already has 5 products");
        }

        if(!products.contains(product)){
            products.add(product);
            product.getCourses().add(this);
        }
    }

    public List<DriverCourse> getDriverCourse() {
        return driverCourse;
    }




}
