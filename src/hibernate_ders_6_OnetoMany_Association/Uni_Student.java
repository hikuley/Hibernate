package hibernate_ders_6_OnetoMany_Association;

import javax.persistence.*;

/**
 * Created by halil on 20.09.2014.
 */
@Entity
public class Uni_Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int student_id;
    private String sutudentName;
    private String studentSurname;

    @ManyToOne(cascade = CascadeType.ALL)
    private Univercity univercity;

    public Uni_Student() {
    }

    public Uni_Student(String sutudentName, String studentSurname, Univercity univercity) {
        this.sutudentName = sutudentName;
        this.studentSurname = studentSurname;
        this.univercity = univercity;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getSutudentName() {
        return sutudentName;
    }

    public void setSutudentName(String sutudentName) {
        this.sutudentName = sutudentName;
    }

    public String getStudentSurname() {
        return studentSurname;
    }

    public void setStudentSurname(String studentSurname) {
        this.studentSurname = studentSurname;
    }

    public Univercity getUnivercity() {
        return univercity;
    }

    public void setUnivercity(Univercity univercity) {
        this.univercity = univercity;
    }
}
