package hibernate_ders_12_Queries_3;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by halil on 27.09.2014.
 */
@Entity
public class Supplier implements Serializable { // Tedarikçi

    @Id
    @GeneratedValue //default Auto
    private int id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "supplier") // mappedBy = "supplier" ile iki tablonun  dılında üçüncü bir tablo oluşturulmaz
    private List<Product> productList = new ArrayList<Product>();

    public Supplier() {
    }

    public Supplier(String name, List<Product> productList) {
        this.name = name;
        this.productList = productList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
