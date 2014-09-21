package hibernate_ders_2;

import hibernate_ders_3.Address;
import hibernate_ders_3.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * Created by halil on 15.09.2014.
 */
public class Test {

    public static void main(String[] args) {
        AnnotationConfiguration configuration = new AnnotationConfiguration();
        configuration.addAnnotatedClass(Student.class);
        configuration.addAnnotatedClass(Address.class);
        configuration.configure("config/hibernate.cfg.xml");


        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction(); // işlem başlangıç


        Customer customer = new Customer();
        customer.setName("Halil");
        customer.setAddress("Besiktas");

        Customer customer2 = new Customer();
        customer2.setName("Kuley");
        customer2.setAddress("Umraniye");

        session.save(customer);
        session.save(customer2);

        session.getTransaction().commit();// işlem bitiş
    }

}
