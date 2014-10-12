package hibernate_ders_14_Criteria_Queries_02;

import hibernate_ders_13_Criteria_Queries_01.Employee1;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.*;

import javax.persistence.criteria.Order;
import java.util.Iterator;
import java.util.List;

/**
 * Created by halil on 11.10.2014.
 */
public class Criterias {

    private Session session;

    public Criterias(Session session) {
        this.session = session;
    }

    public void executeSimpleCriteria() {
        Criteria criteria = session.createCriteria(Employee1.class);
        List resultList = criteria.list();
        displayCriteriaList(resultList);
    }

    public void executeEqualsCriteria() {
        Criteria criteria = session.createCriteria(Employee1.class);
        criteria.add(Restrictions.eq("lastname", "Kuley15")); //equals yani eşit olanları getir.
        List resultList = criteria.list();
        displayCriteriaList(resultList);
    }

    public void executeNotEqualsCriteria() {// not equals => eşit olmayanları getir.
        Criteria criteria = session.createCriteria(Employee1.class);
        criteria.add(Restrictions.ne("name", "Halil15"));
        List resultList = criteria.list();
        displayCriteriaList(resultList);
    }

    public void executeLikePatternCriteria() {
        Criteria criteria = session.createCriteria(Employee1.class);
        criteria.add(Restrictions.like("name", "%15")); // like ifadesi
        List resultList = criteria.list();
        displayCriteriaList(resultList);
    }

    public void executeGreaterThanCriteria() {
        Criteria criteria = session.createCriteria(Employee1.class);
        criteria.add(Restrictions.gt("salary", 1400));
        List resultList = criteria.list();
        displayCriteriaList(resultList);
    }

    public void executeAndCriteria() {
        Criteria criteria = session.createCriteria(Employee1.class);
        criteria.add(Restrictions.gt("salary", 1500));
        criteria.add(Restrictions.like("lastname", "%15"));
        List resultList = criteria.list();
        displayCriteriaList(resultList);
    }

    public void executeOrCriteria() {
        Criteria criteria = session.createCriteria(Employee1.class); //Criteria= kriterler
        Criterion salary = Restrictions.gt("salary", 1500);
        Criterion id = Restrictions.eq("id", 15);
        LogicalExpression logicalExpression = Restrictions.or(salary, id);
        criteria.add(logicalExpression);
        List resultList = criteria.list();
        displayCriteriaList(resultList);
    }

    public void executeDisjunction() { // birden fazlar or kullanımak için Disjunction nesnesi kullanılır.
        Criteria criteria = session.createCriteria(Employee1.class);
        Criterion salary = Restrictions.gt("salary", 1500);
        Criterion lastname = Restrictions.like("lastname", "%15");
        Criterion name = Restrictions.ilike("name", "%20");
        Disjunction disjunction = Restrictions.disjunction();
        disjunction.add(salary);
        disjunction.add(lastname);
        disjunction.add(name);
        criteria.add(disjunction);
        List resultList = criteria.list();
        displayCriteriaList(resultList);
    }

    public void executeSQLCriteria() {
        Criteria criteria = session.createCriteria(Employee1.class);
        criteria.add(Restrictions.sqlRestriction("name like '%15'")); // native sql yazmak için kullanılır.
        List resultList = criteria.list();
        displayCriteriaList(resultList);
    }

    public void executePagingCriteria() {
        Criteria criteria = session.createCriteria(Employee1.class);
        criteria.setFirstResult(5);
        criteria.setMaxResults(3);
        List resultList = criteria.list();
        displayCriteriaList(resultList);
    }

    public void executeOrderCriteria() {
        Criteria criteria = session.createCriteria(Employee1.class);
        criteria.add(Restrictions.gt("salary", 2000));
        criteria.addOrder(org.hibernate.criterion.Order.desc("id")); //descending azalan .. ascending artan => id değerine göre azaltarak getirdik kayıtları.
        List resultList = criteria.list();
        displayCriteriaList(resultList);
    }

    public void executeAggregatesCriteria() {
        Criteria criteria = session.createCriteria(Employee1.class);
        ProjectionList projectionList = Projections.projectionList();
        projectionList.add(Projections.max("salary"));
        projectionList.add(Projections.min("salary"));
        projectionList.add(Projections.avg("salary"));
        projectionList.add(Projections.countDistinct("name"));
        criteria.setProjection(projectionList);
        List resultList = criteria.list();
        displayCriteriaObjectList(resultList);
    }

    public void executeProjectionCriteria() {
        Criteria criteria = session.createCriteria(Employee1.class);
        ProjectionList projectionList = Projections.projectionList();
        projectionList.add(Projections.property("name"));
        projectionList.add(Projections.property("lastname"));
        criteria.setProjection(projectionList);
        List resultList = criteria.list();
        displayCriteriaObjectList(resultList);

    }

    public void displayCriteriaList(List list) {
        Iterator iterator = list.iterator();
        if (!iterator.hasNext()) {
            System.out.println("Kayıt bulunamadı");
            return;
        }
        while (iterator.hasNext()) {
            Employee1 employee1 = (Employee1) iterator.next();
            String s = "Name:" + employee1.getName();
            s += " LastName:" + employee1.getLastname();
            s += " Salary:" + employee1.getSalary();
            s += " Id:" + employee1.getId() + "\t";
            System.out.println(s);
        }

    }

    public void displayCriteriaObjectList(List list) {
        Iterator iterator = list.iterator();
        if (iterator.hasNext()) {
            Object[] objects = (Object[]) iterator.next();
            for (int i = 0; i < objects.length; i++) {
                System.out.println(objects[i]);
            }
        } else {
            System.out.println("Kayıt bulunamadı");
        }

    }
}
