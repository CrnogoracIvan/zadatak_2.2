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
public class Zadatak4BrisanjeVrednosti {

    static Dao<Brod,Integer> brodDao;
    static Dao<Kontejner,Integer> kontejnerDao;

    public static void main(String[] args) {

        ConnectionSource connectionSource = null;

        try {

            connectionSource=new JdbcConnectionSource("jdbc:sqlite:brodKontejner.db");

            brodDao = DaoManager.createDao(connectionSource, Brod.class);
            kontejnerDao = DaoManager.createDao(connectionSource, Kontejner.class);

            List<Kontejner> kontejneri = kontejnerDao.queryForAll();
            for (Kontejner K: kontejneri) {
                System.out.println(K);
            }

            kontejneri = kontejnerDao.queryForEq(Kontejner.POLJE_OZNAKA,"KP2");
            Kontejner zaBrisanje = kontejneri.get(0);

            kontejnerDao.delete(zaBrisanje);

            kontejneri = kontejnerDao.queryForAll();
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
