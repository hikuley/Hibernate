package hibernate_ders_3;

import config.HiberateConfig;
import org.hibernate.Session;

/**
 * Created by halil on 15.09.2014.
 */
public class Test {


    public static void main(String[] args) {


        Address address = new Address();
        address.setCity("Erzurum");
        address.setRoad("Mecburiyet caddesi");
        address.setStreet("Karanlık sokak");
        address.setZipCode("25000");


        Student student = new Student();
        student.setAddress(address);
        student.setStudentName("Halil Ibrahim");
        student.setStudentSurname("Kuley");

        Session session = HiberateConfig.getSession();
        session.beginTransaction(); // işlem başlangıç

        session.save(student);

        session.getTransaction().commit();// işlem bitiş

    }
}
