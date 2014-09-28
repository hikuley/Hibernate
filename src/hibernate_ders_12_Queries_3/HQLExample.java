package hibernate_ders_12_Queries_3;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by halil on 27.09.2014.
 */
public class HQLExample {

    public void executeExampleProduct(Session session) { //HQL orneği tüm prodactı listeler
        Query query = session.createQuery("from Product "); // bir adet query oluşturuyoruz.
        List results = query.list();
        displayProductsList(results);
    }

    public void executeExampleSupplier(Session session) { //HQL orneği tüm Sıpplier listeler
        Query query = session.createQuery("from Supplier"); // bir adet query oluşturuyoruz.
        List results = query.list();
        displaySupplierList(results);
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

    public void executeObjectNamedParamertersHQL(Session session) { // daha sonra bakılacak
        String supplierHql = "from Supplier where name='Kamil'";
        Query supplierQuery = session.createQuery(supplierHql);
        Supplier supplierr = (Supplier) supplierQuery.list().get(0); // ilk değerini aldık


        String hql = "from Product as product  where product.supplier=:supplierr";// as product => Product nesnesini referans alır
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

    public void executeUniqueResult(Session session) {
        String hql = "from Product p where p.price<150 order by p.price desc";
        Query query = session.createQuery(hql);
        query.setMaxResults(1);
        Product product = (Product) query.uniqueResult();
        List results = new ArrayList();
        results.add(product);
        displayProductsList(results);
    }

    public void executeOrderTwoPropertiesHQL(Session session) {
        String hql = "from Product p order by p.supplier.name asc ,p.price asc"; //supplier tablosundaki name ve product tablosundaki price göre küçükten büyüğe doğru sıralama yaptık.
        Query query = session.createQuery(hql);
        List result = query.list();
        displayProductsList(result);
    }

    public void executeOrderHQL(Session session) {
        String hql = "from Product p where p.price<4500 order by p.price desc";
        Query query = session.createQuery(hql);
        List list = query.list();
        displayProductsList(list);
    }

    public void executeAssoctionsHQL(Session session) {// ilişkili iki tablodanda kayıt çekmek için kullanılır.
        String hql = "select s.name, p.name, p.price from Product p inner join p.supplier as s";
        Query query = session.createQuery(hql);
        List list = query.list();
        diplayObjectsList(list);
    }

    public void executeCountHQL(Session session) {
        String hql = "select count (distinct product.supplier.name) from Product product"; //distinct attrubute ile farklı isimlerki kayıtların sayısını getirmiş olduk.
        Query query = session.createQuery(hql);
        Long result = (Long) query.uniqueResult(); // sonuç
        System.out.println(result);
    }

    public void executeMaxMinHQL(Session session) {
        String hql = "select min(product.price),max(product.price) from Product product"; // tablodaki belirtilen alandaki minumum ve maximum değerleri getirir.
        Query query = session.createQuery(hql);
        List list = query.list();
        diplayObjectsList(list);
    }

    public void executeScalarSQL(Session session) {
        String sql = "SELECT avg(product.price) as avgPrice from Product product"; //AVG ile sütun ortalamasını aldık.
        SQLQuery sqlQuery = session.createSQLQuery(sql);// SQLQuery nesnesi yada Query nesnesi kullanılabilir.
//        Query sqlQuery = session.createSQLQuery(sql);
        List list = sqlQuery.list();
        displayObjectList(list);
    }

    public void executeSelectSQL(Session session) {
        String sql = "SELECT * from Supplier supplier"; //'supplier' =>Supplier tablosuna referans olmaktadır.
        SQLQuery sqlQuery = session.createSQLQuery(sql);
        sqlQuery.addEntity("supplier", Supplier.class);// Sorguya Entity ekleyerek klasik sql yazmış olduk.
        List list = sqlQuery.list();
        displaySupplierList(list);
    }

    public void excuteUpdateHQL(Session session) {
        String hql = "update Supplier set name=:newName where name=:name";
        Query query = session.createQuery(hql); //query oluşturmak için kullanılır.
        query.setString("name", "Kamil"); //":name" anahtarı olan alana eşitler
        query.setString("newName", "Kamil Bey");//":newName" anahtarı olan alana denk gelir.
        query.executeUpdate(); // query çalıştırmak için kullanılır.

        String hqlSelect = "from Supplier";
        Query querySelect = session.createQuery(hqlSelect);
        List list = querySelect.list();
        displaySupplierList(list);
    }

    public void executeSoftwareList(Session session) {
        String hql = "from Product where DTYPE='Software'";
        Query query = session.createQuery(hql);
        List list = query.list();
        displaySoftwareList(list);
    }

    public void displaySoftwareList(List list) {
        Iterator iterator = list.iterator();
        if (iterator.hasNext()) {
            while (iterator.hasNext()) {
                Software software = (Software) iterator.next();
                String msg = software.getName() + "\t";
                msg += software.getDesciription() + "\t";
                msg += software.getPrice() + "\t";
                msg += software.getVersion() + "\t";
                System.out.println(msg);
            }
        } else {
            System.out.println("No Software to display.");
        }
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

    public void displaySupplierList(List list) {
        Iterator iter = list.iterator();
        if (!iter.hasNext()) {
            System.out.println("No supplier display");
        }
        while (iter.hasNext()) {
            Supplier supplier = (Supplier) iter.next();
            String msg = supplier.getId() + "\t";
            msg += supplier.getName() + "\t";
            System.out.println(msg);
            System.out.println("\t");
        }
    }

}
