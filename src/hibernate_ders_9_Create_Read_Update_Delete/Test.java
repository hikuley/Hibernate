package hibernate_ders_9_Create_Read_Update_Delete;

import config.HiberateConfig;
import org.hibernate.Session;

/**
 * Created by halil on 21.09.2014.
 */
public class Test {

    public static void main(String[] args) {
        Session session = HiberateConfig.getSession();
        session.beginTransaction();

//        for (int i = 0; i < 20; i++) {
//            Users users = new Users("Halil ibrahim" + i, "Kuley" + i);
//            session.save(users);
//        }

//        Users user = (Users) session.get(Users.class, 5); //Kayıdı seçtik getirdik.
//        user.setAd("Name Updated");
//        user.setSoyad("Surname Updated");
//        session.update(user); // kayıtı güncelledik bu bu satırı aslında yazmamıza bile gerek yoktur.

//        Users user = (Users) session.get(Users.class, 15); // nesnemizi seçtik
//        session.delete(user); // daha sonra nesnemizi sildik

//        Users users = new Users(); // bir nesne kendimiz oluşturduk
//        users.setId(5);//nesnemizi delete methoduna verdik ve sildik.
//        session.delete(users);

        session.getTransaction().commit();
    }
}
