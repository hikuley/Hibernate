package OkulOgrenciAdresExisting;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by halil on 20.09.2014.
 */

@Entity
@Table(name = "Ogrenciler")
public class Ogrenciler implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "OgrenciAdi")
    private String OgrenciAdi;

    @Column(name = "OgrenciSoyadi")
    private String OgrenciSoyadi;

    @Column(name = "OgrenciTCno")
    private String OgrenciTCno;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Ogretmen_id") //öğrencinin öğretmenini tabloda kayıt etmek için . . .
    private Ogretmenler Ogretmen;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adres_id")
    private Adres adres;


    public Ogrenciler() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOgrenciAdi() {
        return OgrenciAdi;
    }

    public void setOgrenciAdi(String ogrenciAdi) {
        OgrenciAdi = ogrenciAdi;
    }

    public String getOgrenciSoyadi() {
        return OgrenciSoyadi;
    }

    public void setOgrenciSoyadi(String ogrenciSoyadi) {
        OgrenciSoyadi = ogrenciSoyadi;
    }

    public String getOgrenciTCno() {
        return OgrenciTCno;
    }

    public void setOgrenciTCno(String ogrenciTCno) {
        OgrenciTCno = ogrenciTCno;
    }

    public Ogretmenler getOgretmen() {
        return Ogretmen;
    }

    public void setOgretmen(Ogretmenler ogretmen) {
        Ogretmen = ogretmen;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }
}
