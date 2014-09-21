package OkulOgrenciAdresExisting;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by halil on 20.09.2014.
 */
@Entity
@Table(name = "Ogretmenler")
public class Ogretmenler implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "OgretmenAdi")
    private String OgretmenAdi;

    @Column(name = "OgretmenSoyadi")
    private String OgretmenSoyadi;

    @Column(name = "OgretmenTcno")
    private String OgretmenTcno;

    @Column(name = "OkulAdi")
    private String OkulAdi;

    @OneToMany(mappedBy = "Ogretmen", cascade = CascadeType.ALL) // CascadeType.ALL ilişkili olan tüm nesneleri tek bir nesne üzerinden kayıt etmek için kullınılır

    private Set<Ogrenciler> ogrenci;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adres_id")
    private Adres adres;

    public Ogretmenler() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOgretmenAdi() {
        return OgretmenAdi;
    }

    public void setOgretmenAdi(String ogretmenAdi) {
        OgretmenAdi = ogretmenAdi;
    }

    public String getOgretmenSoyadi() {
        return OgretmenSoyadi;
    }

    public void setOgretmenSoyadi(String ogretmenSoyadi) {
        OgretmenSoyadi = ogretmenSoyadi;
    }

    public String getOgretmenTcno() {
        return OgretmenTcno;
    }

    public void setOgretmenTcno(String ogretmenTcno) {
        OgretmenTcno = ogretmenTcno;
    }

    public String getOkulAdi() {
        return OkulAdi;
    }

    public void setOkulAdi(String okulAdi) {
        OkulAdi = okulAdi;
    }

    public Set<Ogrenciler> getOgrenci() {
        return ogrenci;
    }

    public void setOgrenci(Set<Ogrenciler> ogrenci) {
        this.ogrenci = ogrenci;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }
}
