package zadaci;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import model.Brod;
import model.Kontejner;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by androiddevelopment on 20.1.17..
 */
public class Zadatak2DodavanjeVrednosti {

    static Dao<Brod,Integer> brodDao;
    static Dao<Kontejner,Integer> kontejnerDao;

    public static void main(String[] args) {

        ConnectionSource connectionSource = null;

        try {

            connectionSource=new JdbcConnectionSource("jdbc:sqlite:brodKontejner.db");

            brodDao = DaoManager.createDao(connectionSource, Brod.class);
            kontejnerDao = DaoManager.createDao(connectionSource, Kontejner.class);

            Brod Brod1 = new Brod ("Brod1","Transporter1");
            brodDao.create(Brod1);

            Brod Brod2 = new Brod ("Brod2","Transporter2");
            brodDao.create(Brod2);

            Kontejner KP1 = new Kontejner("KP1","Namestaj", 100.0);
            KP1.setBrod(Brod1);
            kontejnerDao.create(KP1);

            Kontejner KP2 = new Kontejner("KP2","Banane", 1000.5);
            KP2.setBrod(Brod1);
            kontejnerDao.create(KP2);

            Kontejner KP3 = new Kontejner("KP3","Morski proizvodi", 200.7);
            KP3.setBrod(Brod1);
            kontejnerDao.create(KP3);

            Kontejner KP4 = new Kontejner("KP4","Mercedes", 500.4);
            KP4.setBrod(Brod2);
            kontejnerDao.create(KP4);

            Kontejner KP5 = new Kontejner("KP5","Klavir", 100.0);
            KP5.setBrod(Brod2);
            kontejnerDao.create(KP5);

            List<Brod> brodovi = brodDao.queryForAll();
            for (Brod B: brodovi) {
                System.out.println(B);
            }

            List<Kontejner> kontejneri = kontejnerDao.queryForAll();
            for (Kontejner K: kontejneri) {
                System.out.println(K);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {

                connectionSource.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
