package hibernate_ders_7_ManytoMany_Association;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by halil on 20.09.2014.
 */
@Entity
@Table(name = "Yazar")
public class AutHour {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String surname;

    @ManyToMany
    private Set<Book> books = new HashSet<Book>();


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

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
