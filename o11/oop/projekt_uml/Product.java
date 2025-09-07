package basics.o11.oop.projekt_uml;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Product {
    private String name;
    private String price;
    private String Category;
    private List<Course> courses = new ArrayList<>();
    private List<Seller> sellers = new ArrayList<>();


    public Product(String name, String category, String price) {
        this.name = name;
        Category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public String getCategory() {
        return Category;
    }

    public String getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) && Objects.equals(price, product.price) && Objects.equals(Category, product.Category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, Category);
    }

    public List<Seller> getSellers() {
        return sellers;
    }
}
