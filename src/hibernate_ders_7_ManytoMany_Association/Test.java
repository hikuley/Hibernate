package hibernate_ders_7_ManytoMany_Association;

import config.HiberateConfig;
import org.hibernate.Session;

import java.util.Calendar;

/**
 * Created by halil on 20.09.2014.
 */
public class Test {

    public static void main(String[] args) {
        Calendar publicationDate1 = Calendar.getInstance();
        Calendar publicationDate2 = Calendar.getInstance();
        Calendar publicationDate3 = Calendar.getInstance();


        AutHour autHour1 = new AutHour();
        AutHour autHour2 = new AutHour();

        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();

        autHour1.setName("Can");
        autHour1.setSurname("Dündar");

        autHour2.setName("İskender");
        autHour2.setSurname("Pala");



        publicationDate1.set(1990, Calendar.APRIL, 1);
        book1.setTitle("Sonsuzluk");
        book1.setPages(123);
        book1.setPublicationDate(publicationDate1);

        publicationDate2.set(2009, Calendar.AUGUST, 25);
        book2.setTitle("Şah ve Sultan");
        book2.setPages(700);
        book2.setPublicationDate(publicationDate2);

        publicationDate3.set(2005, Calendar.JULY, 2);
        book3.setTitle("Şekil Adam");
        book3.setPages(26);
        book3.setPublicationDate(publicationDate3);

        book1.getAutHours().add(autHour1);
        book2.getAutHours().add(autHour2);
        book2.getAutHours().add(autHour1);

        Session session = HiberateConfig.getSession();
        session.beginTransaction();


        session.save(book1);
        session.save(book2);
        session.save(book3);

        session.save(autHour1);
        session.save(autHour2);

        session.getTransaction().commit();

    }
}
