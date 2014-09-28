package hibernate_ders_12_Queries_3;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created by halil on 27.09.2014.
 */
@Entity
public class Software extends Product implements Serializable {
    private String version;

    public Software() {

    }

    public Software(Supplier supplier, String name, String desciription, double price, String version) {
        super(supplier, name, desciription, price); //Süper sınıfımıza değerleri set ettik.
        this.version = version;// bu sınıfın kendi propertisine bir değer set ettik.
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
