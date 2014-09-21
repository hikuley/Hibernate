package hibernate_ders_5_OnetoOne_Association;

import javax.persistence.*;

/**
 * Created by halil on 16.09.2014.
 */
@Entity
public class Citizen {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int citizen_id;
    private String name;
    private String surname;

    @OneToOne(cascade = CascadeType.ALL) // bir nesneyi save() ederk aynı anda iki tabloyuda save etmiş oluruz
    @JoinColumn(name = "adrressId")
    private CitizenAdrress adrress;

    public int getCitizen_id() {
        return citizen_id;
    }

    public void setCitizen_id(int citizen_id) {
        this.citizen_id = citizen_id;
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

    public CitizenAdrress getAdrress() {
        return adrress;
    }

    public void setAdrress(CitizenAdrress adrress) {
        this.adrress = adrress;
    }
}
