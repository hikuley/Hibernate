package hibernate_ders_1_Giris_ve_kurulum;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


/**
 * Created by halil on 14.09.2014.
 */
public class Test {


    public static void main(String[] args) {
        User user = new User();
        user.setFirstName("Halil İbrahim");
        user.setLastName("hiKüley");

        Personel personel = new Personel();
        personel.setFirstName("deneme");
        personel.setLastName("123");


        AnnotationConfiguration config = new AnnotationConfiguration();
        config.addAnnotatedClass(User.class);
        config.configure("config/hibernate.cfg.xml");
//        new SchemaExport(config).create(true, true); //tablomuzu yeniden oluşturmak için kullanılır

        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();


        session.save(user);

        session.getTransaction().commit();
    }
}
