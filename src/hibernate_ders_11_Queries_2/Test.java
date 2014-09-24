package hibernate_ders_11_Queries_2;

import config.HiberateConfig;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by halil on 22.09.2014.
 */
public class Test {
    public static void main(String[] args) {

        Session session = HiberateConfig.getSession();
        session.beginTransaction();

//        Query query = session.createQuery("from Workers2 "); //HQL a sınıf ismi kullanılır
//        Query query = session.createSQLQuery("SELECT * FROM Workers_new_table"); //Native sql de ise database de geçen isim kullanılır.
//        List list = query.list();

        Query query1 = session.getNamedQuery("query1"); //Entity sınıfındaki query1 sorgusunu çektik
        query1.setInteger(0, 5); // değer set ettik
        List list1 = query1.list(); // değerleri listeledik.

        Query query2 = session.getNamedQuery("query2");//
        query2.setString(0, "Halil3");
        List list2 = query2.list();


        session.getTransaction().commit();
    }

}
