package hibernate_ders_12_Queries_3;

import config.HiberateConfig;
import org.hibernate.Session;

/**
 * Created by halil on 27.09.2014.
 */
public class Test {

    public static void main(String[] args) {


        Session session = HiberateConfig.getSession(); //---Transaction Start
        session.beginTransaction();
//
//        for (int i = 0; i < 20; i++) {
//            Supplier supplier = new Supplier();
//            supplier.setName("Mehmet Ibrahim Pasa");
//
//
//            Software software = new Software();
//            software.setName("Ubuntu");
//            software.setDesciription("Acik kaynakli the Operation system");
//            software.setPrice(100);
//            software.setVersion("14.11");
//
//
////            Product product = new Product();
////            product.setName("Mac Air 13'' ");
////            product.setDesciription("Guzel bir pc dir.");
////            product.setPrice(4500);
//
//
//            // İki tabloyuda ilişkilendirdik.
//            software.setSupplier(supplier);
//            supplier.getProductList().add(software);
//            // İki tabloyuda ilişkilendirdik.
//            session.save(supplier);//--- Kayıt
//        }
        HQLExample hqlExample = new HQLExample();
        hqlExample.executeSoftwareList(session);

        session.getTransaction().commit(); //---Transaction Start
    }
}
