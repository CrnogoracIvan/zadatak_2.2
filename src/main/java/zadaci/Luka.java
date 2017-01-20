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
public class Luka {

    static Dao<Brod,Integer> brodDao;
    public static Integer brojPristiglihBrodova = 0;
    public static int brojBrodova = 0;



    public static void main(String[] args) {
        ConnectionSource connectionSource = null;

        try {
            connectionSource=new JdbcConnectionSource("jdbc:sqlite:brodKontejner.db");
            brodDao = DaoManager.createDao(connectionSource, Brod.class);


            List<Brod> brodovi = brodDao.queryForAll();
            for (Brod B: brodovi) {
                brojBrodova++;
            }

            System.out.println("Broj brodova je: " + brojBrodova);
            BrodNit b1= new BrodNit(brodovi.get(0));
            BrodNit b2= new BrodNit(brodovi.get(1));

            b1.start();
            b2.start();


        }catch (SQLException e) {
            e.printStackTrace();

        }finally {

            try {

                connectionSource.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



        System.out.println("Broj pristiglih brodova je: " + Luka.brojPristiglihBrodova);


    }


}
