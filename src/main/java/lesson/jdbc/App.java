package lesson.jdbc;

import lesson.http.util.DbConnectionUtils;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.SQLException;

public class App {
    @SneakyThrows
    public static void main(String[] args) {
        Class.forName("org.postgresql.Driver");
        dbInit();
    }

    private static void dbInit() {
        try (Connection connection = DbConnectionUtils.getConnection()) {
            String sqlQuery = """
                    CREATE TABLE IF NOT EXISTS users (
                        id serial PRIMARY KEY,
                        username VARCHAR (50) UNIQUE NOT NULL,
                        email VARCHAR (255) UNIQUE NOT NULL,
                        created_on TIMESTAMP NOT NULL
                    );
                    CREATE TABLE IF NOT EXISTS history (
                        id serial PRIMARY KEY,
                        username VARCHAR (50) UNIQUE NOT NULL,
                        email VARCHAR (255) UNIQUE NOT NULL,
                        created_on TIMESTAMP NOT NULL
                    """;
            var statement = connection.createStatement();
            statement.executeUpdate(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
