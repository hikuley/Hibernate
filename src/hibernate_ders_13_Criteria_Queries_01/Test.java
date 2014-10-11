package hibernate_ders_13_Criteria_Queries_01;

import config.HiberateConfig;
import org.hibernate.Session;

/**
 * Created by halil on 08.10.2014.
 */
public class Test {
    public static void main(String[] args) {

        Session session = HiberateConfig.getSession();
        session.beginTransaction(); // Transaction başlangıç.

//        for (int i = 0; i < 20; i++) {
//            Employee1 employee1 = new Employee1();
//            employee1.setName("Halil" + i);
//            employee1.setLastname("Kuley" + i);
//            employee1.setSalary(150 * i);
//            session.save(employee1);
//        }

        Criterias criterias = new Criterias();
//        criterias.executeSimpleCriteria(session);
//        criterias.executeNotEqualsCriteria(session);
//        criterias.executeLikePatternCriteria(session);
//        criterias.executeGreaterThanThanCriteria(session);
//        criterias.executeAndCriteria(session);
        criterias.executeOrCriteria(session);
        session.getTransaction().commit();// Transaction bitiş.
    }

}
