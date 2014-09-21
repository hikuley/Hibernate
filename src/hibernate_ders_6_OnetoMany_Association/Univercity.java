package hibernate_ders_6_OnetoMany_Association;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by halil on 20.09.2014.
 */

@Entity
public class Univercity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int univercityId;
    private String univercityName;
    private String faculty;
    private String department;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Uni_Student> uni_students = new ArrayList<Uni_Student>();


    public Univercity() {

    }

    public Univercity(String univercityName, String faculty, String department) {
        this.univercityName = univercityName;
        this.faculty = faculty;
        this.department = department;
    }

    public int getUnivercityId() {
        return univercityId;
    }

    public void setUnivercityId(int univercityId) {
        this.univercityId = univercityId;
    }

    public String getUnivercityName() {
        return univercityName;
    }

    public void setUnivercityName(String univercityName) {
        this.univercityName = univercityName;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Uni_Student> getUni_students() {
        return uni_students;
    }

    public void setUni_students(List<Uni_Student> uni_students) {
        this.uni_students = uni_students;
    }


}
