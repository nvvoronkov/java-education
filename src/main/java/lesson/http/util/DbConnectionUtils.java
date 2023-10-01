package lesson.http.util;

import lombok.experimental.UtilityClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@UtilityClass
public class DbConnectionUtils {

    public static Connection getConnection() {
        String url = ReadPropertiesUtils.readProperty("DB_URL");
        String user = ReadPropertiesUtils.readProperty("DB_USER");
        String password = ReadPropertiesUtils.readProperty("DB_PASSWORD");

        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
