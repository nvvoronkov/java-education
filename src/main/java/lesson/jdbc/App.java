package lesson.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) {
        // Замените следующие переменные вашими данными
        String url = "jdbc:postgresql://localhost:5432/ваша_база_данных";
        String user = "ваш_пользователь";
        String password = "ваш_пароль";

        try {
            // Загрузите драйвер JDBC для PostgreSQL
            Class.forName("org.postgresql.Driver");

            // Установите соединение с базой данных
            Connection connection = DriverManager.getConnection(url, user, password);

            // Пример выполнения SQL-запроса
            String sqlQuery = "SELECT * FROM ваша_таблица";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            // Обработка результатов запроса
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("имя");
                // Ваши действия с данными
                System.out.println("ID: " + id + ", Имя: " + name);
            }

            // Закрытие ресурсов
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
