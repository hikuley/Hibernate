package hibernate_ders_11_Queries_2;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by halil on 22.09.2014.
 */
@Entity
@NamedQuery(name = "query1", query = "from Workers2 where id=?") // hql de direkt sınıf ismini kullanmak gerekir.
@NamedNativeQuery(name = "query2", query = "SELECT * FROM Workers_new_table WHERE name=?")// native query de ise veri tabanında geçen ismi kulanmak gerekir.
@Table(name = "Workers_new_table")
public class Workers2 implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String surname;
    private int Salary;

    public Workers2() {
    }

    public Workers2(String name, String surname, int salary) {
        this.name = name;
        this.surname = surname;
        this.Salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }
}
