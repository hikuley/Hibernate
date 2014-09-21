package hibernate_ders_3;

import javax.persistence.*;

/**
 * Created by halil on 15.09.2014.
 */
@Entity
public class Student {
    private int sududentId;
    private String studentName;
    private String studentSurname;

    private Address address;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "yeniId")
    public int getSududentId() {
        return sududentId;
    }

    public void setSududentId(int sududentId) {
        this.sududentId = sududentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentSurname() {
        return studentSurname;
    }

    public void setStudentSurname(String studentSurname) {
        this.studentSurname = studentSurname;
    }

    @Embedded
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
