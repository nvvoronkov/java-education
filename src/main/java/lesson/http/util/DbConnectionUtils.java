package lesson.http.util;

import lombok.experimental.UtilityClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@UtilityClass
public class DbConnectionUtils {


    public static Connection getConnection() {
        String url = "jdbc:postgresql://localhost:5432/http";
        String user = "igorsimakov";
        String password = "admin";

        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
