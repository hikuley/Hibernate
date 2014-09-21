package hibernate_ders_8_Inheritance;

import config.HiberateConfig;
import org.hibernate.Session;

/**
 * Created by halil on 21.09.2014.
 */
public class Test {

    public static void main(String[] args) {

        Vehicle vehicle=new Vehicle();
        vehicle.setVehicleName("Ford");

        TwoWheeler bike=new TwoWheeler();
        bike.setVehicleName("Bike");
        bike.setSteeringHandle("bisiklet bisiklettir");


        FourWheeler car=new FourWheeler();
        car.setVehicleName("Doğan");
        car.setSteeringWheel("Angara arabasi");


        Session session = HiberateConfig.getSession();
        session.beginTransaction();

//        session.save(vehicle);
//        session.save(bike);
        session.save(car);

        session.getTransaction().commit();
    }
}
