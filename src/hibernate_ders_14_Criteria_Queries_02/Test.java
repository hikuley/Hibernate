package hibernate_ders_14_Criteria_Queries_02;

import config.HiberateConfig;
import org.hibernate.Session;

/**
 * Created by halil on 11.10.2014.
 */
public class Test {
    public static void main(String[] args) {
        Session session = HiberateConfig.getSession();
        Criterias criterias = new Criterias(session);

        session.beginTransaction();//Transaction Başlangıç.

//        criterias.executeSimpleCriteria();
//        criterias.executeEqualsCriteria();
//        criterias.executeNotEqualsCriteria();
//        criterias.executeLikePatternCriteria();
//        criterias.executeGreaterThanCriteria();
//        criterias.executeAndCriteria();
//        criterias.executeOrCriteria();
//        criterias.executeDisjunction();
//        criterias.executeSQLCriteria();
//        criterias.executePagingCriteria();
//        criterias.executeOrderCriteria();
//        criterias.executeAggregatesCriteria();
          criterias.executeProjectionCriteria();

        session.getTransaction().commit();//Transaction Bitiş.
    }
}
