package hibernate_ders_5_OnetoOne_Association;

import config.HiberateConfig;
import org.hibernate.Session;

/**
 * Created by halil on 15.09.2014.
 */
public class Test {

    public static void main(String[] args) {

        Citizen citizen = new Citizen();
        citizen.setName("Halil ibo");
        citizen.setSurname("Kuley");

        CitizenAdrress adrress = new CitizenAdrress();
        adrress.setCity("Erzurum");
        adrress.setStreet("Karanlik Sokak");
        adrress.setZipcode("25100");
        adrress.setRoad("Mecburiyet caddesi");

        citizen.setAdrress(adrress);


        Session session = HiberateConfig.getSession();
        session.beginTransaction(); // işlem başlangıç
        session.save(citizen);
        session.getTransaction().commit(); // işlem bitiş
    }


}
