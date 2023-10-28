package lesson.http_jdbc.util;

import lesson.http_jdbc.exeption.MyRuntimeException;
import lombok.experimental.UtilityClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@UtilityClass
public class DbConnectionUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(DbConnectionUtils.class);
    private static final Connection CONNECTION = createConnect();

    private static Connection createConnect() {
        String url = ReadPropertiesUtils.readProperty("db.url");
        String user = ReadPropertiesUtils.readProperty("db.user");
        String password = ReadPropertiesUtils.readProperty("db.password");

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            connection.setAutoCommit(false);
            return connection;
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
            throw new MyRuntimeException(e.getMessage());
        }
    }

    public static Connection getConnection() {
        return CONNECTION;
    }
}
