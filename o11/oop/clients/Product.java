package basics.o11.oop.clients;

public class Product {
    private String productName;
    private Integer price;
    private Integer size;

    public Product(String productName, Integer price, Integer size){
        this.productName = productName;
        this.price = price;
        this.size = size;
    }

    public Product(String productName, Integer price){
        this.productName = productName;
        this.price = price;
    }

    public Integer getSize() {
        return size;
    }

    public Integer getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", price=" + price +
                (size != null ? ", size=" + size : "") +
                '}';
    }
}
