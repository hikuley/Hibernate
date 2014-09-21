package hibernate_ders_8_Inheritance;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by halil on 21.09.2014.
 */
@Entity
//@DiscriminatorColumn(
//        name = "new_vehicle_type",
//        discriminatorType = DiscriminatorType.STRING
//)
//@DiscriminatorValue(value = "Vehicle Class")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)// kalıtılmış sınıfları tek bir tabloda toplar
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // kalıtılmış sınıfları ilişki olmadan ayrı tablolar halide oluşturur
@Inheritance(strategy = InheritanceType.JOINED) //kalıtılmış sınıfları ilişkili tablolar haline getirir
public class Vehicle implements Serializable{ // Araçlar

    @Id
//    @GeneratedValue(strategy = GenerationType.TABLE)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int vehicleId;
    private String vehicleName;


    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }
}
