package hibernate_ders_8_Inheritance;

import javax.persistence.Entity;

/**
 * Created by halil on 21.09.2014.
 */
@Entity
//@DiscriminatorValue(value = "Car Class")
public class FourWheeler extends Vehicle {
    private String SteeringWheel; //direksiyonlu araç

    public FourWheeler() {
    }

    public String getSteeringWheel() {
        return SteeringWheel;
    }

    public void setSteeringWheel(String steeringWheel) {
        SteeringWheel = steeringWheel;
    }
}
