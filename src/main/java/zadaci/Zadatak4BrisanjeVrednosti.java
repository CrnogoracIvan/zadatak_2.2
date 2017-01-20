package zadaci;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by androiddevelopment on 20.1.17..
 */
public class Zadatak4BrisanjeVrednosti {

    public static void main(String[] args) {

        ConnectionSource connectionSource = null;

        try {

            connectionSource=new JdbcConnectionSource("jdbc:sqlite:brodKontejner.db");



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
