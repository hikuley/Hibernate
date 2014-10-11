package hibernate_ders_13_Criteria_Queries_01;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

import java.util.Iterator;
import java.util.List;

/**
 * Created by halil on 11.10.2014.
 */
public class Criterias {

    public void executeSimpleCriteria(Session session) { //Select * from Employee1
        Criteria criter = session.createCriteria(Employee1.class); // criteria referası oluşturduk
        List resultList = criter.list();// criteria dana gelen sonucu list şeklinde aldık
        System.out.println(resultList.toString() + "Sorgu sonucu :\t");
        displayCriteriaList(resultList);
    }

    public void executeNotEqualsCriteria(Session session) { //Select * from employe where name!="halil6" => name halil6 dışındaki kayıtları getirir
        Criteria criter = session.createCriteria(Employee1.class);
        criter.add(Restrictions.ne("name", "Halil6"));
        List resultList = criter.list();
        displayCriteriaList(resultList);
    }

    public void executeLikePatternCriteria(Session session) { //Select * from where lastname like "17%";
        Criteria criteria = session.createCriteria(Employee1.class);
//        criteria.add(Restrictions.like("lastname", "%17%"));// sağında solunda
//        criteria.add(Restrictions.like("lastname", "%17"));//solunda
        criteria.add(Restrictions.like("lastname", "17%"));//sağında "17" ifadesi geçenleri getir.
        List resultList = criteria.list();
        displayCriteriaList(resultList);
    }

    public void executeGreaterThanThanCriteria(Session session) { // select * from Employee1 where salary>2700
        Criteria criteria = session.createCriteria(Employee1.class);
        criteria.add(Restrictions.gt("salary", 2700)); // maaşı 2700 den büyük değerleri listelemek için kullanılır.
        List resultList = criteria.list();
        displayCriteriaList(resultList);
    }

    public void executeOrCriteria(Session session) { //Select * from Employee1 where salary>1600 or like name "%15%"
        Criteria criteria = session.createCriteria(Employee1.class);// creatirea nesnesi oluşturduk.
        Criterion salary = Restrictions.gt("salary", 1600);//"criterion" kriter demek, kriter nesnesi oluşturduk.
        Criterion name = Restrictions.like("name", "%15%");//"criterion" kriter demek, kriter nesnesi oluşturduk.
        LogicalExpression orExp = Restrictions.or(salary, name);// LogicalExpression nesnesi oluşturduk ve kriterlerimizi verdik
        criteria.add(orExp);// kriterlerimizi ekledik
        List resultList = criteria.list(); // listeledik
        displayCriteriaList(resultList);// sorgumuzu gösterdik
    }


    public void executeAndCriteria(Session session) {
        Criteria criteria = session.createCriteria(Employee1.class);
        criteria.add(Restrictions.gt("salary", 1500));
        criteria.add(Restrictions.like("lastname", "%15"));
        List resultList = criteria.list();
        displayCriteriaList(resultList);
    }

    public void displayCriteriaList(List list) { // List objlerini görsel bir şekilde göstermek için
        Iterator iterator = list.iterator();
        if (!iterator.hasNext()) {
            System.out.println("Kayıt bulunumadı");
            return;
        }
        while (iterator.hasNext()) {
            Employee1 employee1 = (Employee1) iterator.next();
            String s = employee1.getName();
            s += " " + employee1.getLastname();
            s += " " + employee1.getSalary();
            System.out.println(s);
        }
    }
}
