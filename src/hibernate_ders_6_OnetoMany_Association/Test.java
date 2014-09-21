package hibernate_ders_6_OnetoMany_Association;

import config.HiberateConfig;
import org.hibernate.Session;

/**
 * Created by halil on 20.09.2014.
 */
public class Test {

    public static void main(String[] args) {


        Univercity univercity = new Univercity();
        univercity.setUnivercityName("Anadolu Üniversitesi");
        univercity.setFaculty("Konservatuar");
        univercity.setDepartment("Oyunculuk");


        Uni_Student uni_student = new Uni_Student();
        uni_student.setSutudentName("Halil İbrahim");
        uni_student.setStudentSurname("Küley");

        univercity.getUni_students().add(uni_student);
        uni_student.setUnivercity(univercity);


        Session session = HiberateConfig.getSession();
        session.beginTransaction();

        /*Kayıt*/
        session.save(univercity);
        /*Kayıt*/

        session.getTransaction().commit();
    }

}
