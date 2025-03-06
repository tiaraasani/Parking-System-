
package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {

    private static Connection connect;

    public static Connection getkoneksi() {
        if (connect == null) {
            try {
                String url = "jdbc:mysql://localhost:3306/parkingapp";
                String user = "root";
                String password = "";
                url = "jdbc:mysql://localhost:3306/parkingapp";
                user = "root";
                password = "";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                connect = DriverManager.getConnection(url, user, password);

            } catch (SQLException t) {
                System.out.println("koneksi error");
            }
        }
        return connect;
    }

}
