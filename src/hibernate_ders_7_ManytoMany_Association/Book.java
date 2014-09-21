package hibernate_ders_7_ManytoMany_Association;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by halil on 20.09.2014.
 */
@Entity
@Table(name = "Kitap")
public class Book implements Serializable {

    @Id
    @Column(name = "KitapID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookId;
    private String title;
    private int pages;

    @Temporal(TemporalType.DATE)
    private Calendar publicationDate;

    @ManyToMany
    private Set<AutHour> autHours = new HashSet<AutHour>();

    public Book() {
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Calendar getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Calendar publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Set<AutHour> getAutHours() {
        return autHours;
    }

    public void setAutHours(Set<AutHour> autHours) {
        this.autHours = autHours;
    }


}
