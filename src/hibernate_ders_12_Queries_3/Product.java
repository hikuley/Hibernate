package hibernate_ders_12_Queries_3;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by halil on 27.09.2014.
 */
@Entity
public class Product implements Serializable {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;
    private String name;
    private String desciription;
    private double price;

    public Product() {
    }

    public Product(Supplier supplier, String name, String desciription, double price) {
        this.name = name;
        this.desciription = desciription;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesciription() {
        return desciription;
    }

    public void setDesciription(String desciription) {
        this.desciription = desciription;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
