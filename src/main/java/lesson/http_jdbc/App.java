package lesson.http_jdbc;

import lombok.SneakyThrows;

public class App {

    @SneakyThrows
    public static void main(final String[] args) {
        Class.forName("org.postgresql.Driver");
    }

    /*В чем ошибка?
    private static void dbInit() {
        Connection connection = DbConnectionUtils.getConnection();
        try {
            String createCity = """
                    CREATE TABLE IF NOT EXISTS city (
                        id INTEGER PRIMARY KEY,
                        name varchar(100) NOT NULL,
                        created_on TIMESTAMP NOT NULL DEFAULT now())
                    """;
            String createHistory = """
                    CREATE TABLE IF NOT EXISTS current_condition_history (
                        id serial PRIMARY KEY,
                        temp FLOAT NOT NULL,
                        city_id bigint NOT NULL REFERENCES city (id),
                        created_on TIMESTAMP NOT NULL DEFAULT now())
                    """;
            var statement = connection.createStatement();
            statement.executeUpdate(createCity);
            statement.executeUpdate(createHistory);

            connection.commit();
        } catch (SQLException e) {
            e.getMessage();
        }
    }*/
}
