package hibernate_ders_10_Queries_1;

import config.HiberateConfig;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.Iterator;
import java.util.List;

/**
 * Created by halil on 22.09.2014.
 */
public class Test {
    public static void main(String[] args) {

        Session session = HiberateConfig.getSession();
        session.beginTransaction();

//        for (int i = 0; i < 20; i++) {
//            Workers workers = new Workers("Hali" + i, "Kuley" + i);
//            session.save(workers);
//        }

        String hql = "from Workers"; // select * from
        Query query = session.createQuery(hql); // sorguyu veritabanına gönderdik ve query adında bir kaynak oluşturduk
        query.setFirstResult(5);//kayıtları kaçıncı sıradan (index) itibaren getireceğini belirmiş olduk
        query.setMaxResults(5); // kaç edet kayıt getirebileceğimizi belirmiş olduk.
        List resultList = query.list();// query den liste ile data mızı aldık

        for (Iterator it = resultList.iterator(); it.hasNext(); ) { // iterator nesnesi ile listedeki elemanları döndürdük
            Workers i = (Workers) it.next();
            System.out.println("Ad: " + i.getName() + " Soyad :" + i.getSurname());
        }

        session.getTransaction().commit();

    }

}
