package hibernate_ders_12_Queries_3;

import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by halil on 27.09.2014.
 */
public class HQLExample {

    public void executeExample(Session session) { //HQL orneği tüm prodactı listeler
        Query query = session.createQuery("from Product "); // bir adet query oluşturuyoruz.
        List results = query.list();
        displayProductsList(results);
    }

    public void executeProtjectionHQL(Session session) {
        Query query = session.createSQLQuery("SELECT * FROM Product");
        List results = query.list();
        diplayObjectsList(results);
    }

    public void executeHQLForRestirictions(Session session) {
        String hql = "from Product where price>100 and name like 'MacPro%'";
        Query query = session.createQuery(hql);
        List results = query.list();
        displayProductsList(results);
    }

    public void executeUniqueResult(Session session) {
        String hql = "from Product p where p.price<150 order by p.price desc";
        Query query = session.createQuery(hql);
        query.setMaxResults(1);
        Product product = (Product) query.uniqueResult();
        List results = new ArrayList();
        results.add(product);
        displayProductsList(results);
    }

    public void executeObjectNamedParamertersHQL(Session session) { // daha sonra bakılacak
        String supplierHql = "from Supplier where name='Kamil'";
        Query supplierQuery = session.createQuery(supplierHql);
        Supplier supplierr = (Supplier) supplierQuery.list().get(0); // ilk değerini aldık


        String hql = "from Product as product  where product.supplier=:supplierr";
        Query query = session.createQuery(hql);
        List resulList = query.list();
        displayProductsList(resulList);

    }

    public void executePaginHQL(Session session) {
        String hql = "from Product ";
        Query query = session.createQuery(hql);
        query.setFirstResult(5);//5. kayıttan itibaren
        query.setMaxResults(5); // 5 adet kayıt getirdi
        List list = query.list();
        displayProductsList(list);
    }

    public void executeOrderTwoPropertiesHQL(Session session) {
        String hql = "from Product p order by p.supplier.name asc ,p.price asc"; //supplier tablosundaki name ve product tablosundaki price göre küçükten büyüğe doğru sıralama yaptık.
        Query query = session.createQuery(hql);
        List result = query.list();
        displayProductsList(result);
    }

    public void diplayObjectsList(List list) {
        Iterator iterator = list.iterator(); //Yineleyici kullandık, kodlarımızı listelemek için tek tek.

        while (iterator.hasNext()) {
            Object[] object = (Object[]) iterator.next();
            for (int i = 0; i < object.length; i++) {
                System.out.println(object[i] + " ");
            }
            System.out.println("\t");
        }

    }

    public void displayProductsList(List list) {
        Iterator iterator = list.iterator();
        if (!iterator.hasNext()) {
            System.out.println("Veri tabanın ürün bulunmamaktadır.");
            return;
        }

        while (iterator.hasNext()) {
            Product product = (Product) iterator.next(); // her bir itarator elemanını Product nesnesine eşitledik.
            String msg = product.getSupplier().getId() + "\t";
            msg += product.getSupplier().getName() + "\t";
            msg += product.getName() + "\t";
            msg += product.getDesciription() + "\t";
            msg += product.getPrice() + "\t";
            System.out.println(msg);
        }

    }


    public void displayObjectList(List list) {
        Iterator iterator = list.iterator();
        if (!iterator.hasNext()) {
            System.out.println("Boş nesne ");
            return;
        }
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println(obj.getClass().getName());
            System.out.println(obj);
        }
    }


}
