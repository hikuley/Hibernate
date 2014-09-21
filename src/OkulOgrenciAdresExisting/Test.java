package OkulOgrenciAdresExisting;

import config.HiberateConfig;
import org.hibernate.Session;

/**
 * Created by halil on 20.09.2014.
 */
public class Test {


    public static void main(String[] args) {
        Adres adres = new Adres();
        adres.setAd("Ofis");
        adres.setMahalle("Karaköse");
        adres.setSokak("DursunBey Sokak");
        adres.setCadde("Cumhuriyet Caddesi");
        adres.setZipcode("2500");

        Adres adres2 = new Adres();
        adres2.setAd("Ofis");
        adres2.setMahalle("Karaköse");
        adres2.setSokak("DursunBey Sokak");
        adres2.setCadde("Cumhuriyet Caddesi");
        adres2.setZipcode("2500");

        Ogretmenler ogretmen = new Ogretmenler();
        ogretmen.setOgretmenAdi("Mahmut");
        ogretmen.setOgretmenSoyadi("Guney");
        ogretmen.setOkulAdi("Ömer Duygun İlk Öğretim okulu");
        ogretmen.setOgretmenTcno("14948075266");
        ogretmen.setAdres(adres2);

        Ogrenciler ogrenci = new Ogrenciler();
        ogrenci.setOgrenciAdi("Mehmet");
        ogrenci.setOgrenciSoyadi("Kurnaz");
        ogrenci.setOgrenciTCno("4564852626");
        ogrenci.setOgretmen(ogretmen);
        ogrenci.setAdres(adres);



        Session session = HiberateConfig.getSession2();
        session.beginTransaction();//-----

        session.save(ogrenci);


        session.getTransaction().commit();//-----
    }
}
