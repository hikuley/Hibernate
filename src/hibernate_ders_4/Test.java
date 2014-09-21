package hibernate_ders_4;

import config.HiberateConfig;
import org.hibernate.Session;

/**
 * Created by halil on 15.09.2014.
 */
public class Test {

    public static void main(String[] args) {


        CompoundKey key1 = new CompoundKey(1002, 1001);
        Accounts account1 = new Accounts();

        account1.setAccountBalnce(600);
        account1.setCompoundKey(key1);

        /*----*/

        CompoundKey key2 = new CompoundKey(1003, 1002);
        Accounts account2 = new Accounts();

        account2.setAccountBalnce(900);
        account2.setCompoundKey(key2);


        Session session = HiberateConfig.getSession();
        session.beginTransaction();
        /*-------------Veri işlemleri-------------*/

        session.save(account1);
        session.save(account2);

        /*-------------Veri işlemleri-------------*/
        session.getTransaction().commit();

    }
}
