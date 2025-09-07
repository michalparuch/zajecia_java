package basics.o11.oop.projekt_uml;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Seller extends Person {
    private Integer hoursWorked;
    private String rank;
    private List<Seller> subordinates = new ArrayList<>();
    private Seller boss;
    private SalesGroup group;
    private List<Product> sellingProucts;

    // TODO jakie produkty sprzedaje

    public Seller(String name, String lastName, LocalDate bornDate, String email, List<String> specialization, Integer hoursWorked, String rank) {
        super(name, lastName, bornDate, email, specialization);
        this.hoursWorked = hoursWorked;
        this.rank = rank;
        calculateSalary();
    }

    public Seller(String name, String lastName, LocalDate bornDate, List<String> specialization, Integer hoursWorked, String rank) {
        super(name, lastName, bornDate, specialization);
        this.hoursWorked = hoursWorked;
        this.rank = rank;
        calculateSalary();
    }

    @Override
    public void calculateSalary() {
        double baseSalary = hoursWorked * 30.0;
        if (rank.equalsIgnoreCase("mid")) {
            baseSalary += 500.0;
        }

        if (rank.equalsIgnoreCase("senior")) {
            baseSalary += 1000.00;
        }
        setSalary(baseSalary);
    }

    public Integer getHoursWorked() {
        return hoursWorked;
    }

    public Seller getBoss() {
        return boss;
    }

    public List<Seller> getSubbordinates() {
        return subordinates;
    }

    public String getRank() {
        return rank;
    }

    public void setSubordinates(List<Seller> subordinates) {
        this.subordinates = subordinates;
    }

    public void setHoursWorked(Integer hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setBoss(Seller boss) {
        if (boss == this) {
            throw new IllegalArgumentException("Seller cannot be their own boss.");
        }
        this.boss = boss;
    }

    public SalesGroup getGroup() {
        return group;
    }

    public void setGroup(SalesGroup newGroup) {
        if (this.group != null && this.group != newGroup) {
            throw new IllegalStateException("Seller already belongs to another group.");
        }
        this.group = newGroup;
    }

    public void addSubordinate(Seller employee) {
        if(this.getSubbordinates().contains(employee)){
            throw new IllegalArgumentException("Seller already in the list");
        }
        subordinates.add(employee);
        employee.setBoss(this);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Seller seller = (Seller) o;
        return Objects.equals(hoursWorked, seller.hoursWorked) && Objects.equals(rank, seller.rank) && Objects.equals(subordinates, seller.subordinates) && Objects.equals(boss, seller.boss) && Objects.equals(group, seller.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hoursWorked, rank, subordinates, boss, group);
    }

    public void addProductToOffer(Product product){
        product.getSellers().add(this);
        sellingProucts.add(product);
    }

}
