package lesson.http_jdbc.util;

import lombok.experimental.UtilityClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@UtilityClass
public class DbConnectionUtils {

    public static Connection getConnection() {
        String url = ReadPropertiesUtils.readProperty("db.url");
        String user = ReadPropertiesUtils.readProperty("db.user");
        String password = ReadPropertiesUtils.readProperty("db.password");

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            connection.setAutoCommit(false);
            return connection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
