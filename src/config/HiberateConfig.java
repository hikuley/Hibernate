package config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * Created by halil on 15.09.2014.
 */
public class HiberateConfig {
    public static Session getSession() {
        AnnotationConfiguration configuration = new AnnotationConfiguration();
        configuration.configure("config/hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        return sessionFactory.getCurrentSession();
    }

    public static Session getSession2() {
        AnnotationConfiguration configuration = new AnnotationConfiguration();
        configuration.configure("config/OkulOgrenci.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        return sessionFactory.getCurrentSession();
    }


}
