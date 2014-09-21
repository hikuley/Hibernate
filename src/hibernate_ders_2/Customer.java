package hibernate_ders_2;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by halil on 14.09.2014.
 */
@Entity
@Table(name = "NEW_CUSTUMER_tabler")
@SecondaryTable(name = "CUSTOMER_DETAILS")
public class Customer implements Serializable {

    private int id;
    private String name;
    private String address;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @Column(table = "CUSTOMER_DETAILS") //2. tabloya eklenecek alan ve ikinci tablonun ismi secondaryde geçen isim olacaktır
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
