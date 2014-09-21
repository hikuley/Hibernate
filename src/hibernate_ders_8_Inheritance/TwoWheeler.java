package hibernate_ders_8_Inheritance;

import javax.persistence.Entity;

/**
 * Created by halil on 21.09.2014.
 */
@Entity
//@DiscriminatorValue(value = "Bike Class")
public class TwoWheeler extends Vehicle { // iki tekerlekli araçlar

    private String steeringHandle; //direksiyonlu

    public TwoWheeler() {
    }

    public String getSteeringHandle() {
        return steeringHandle;
    }

    public void setSteeringHandle(String steeringHandle) {
        this.steeringHandle = steeringHandle;
    }
}
