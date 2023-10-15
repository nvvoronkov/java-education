package lesson.http_jdbc;

import com.fasterxml.jackson.databind.ObjectMapper;
import lesson.http_jdbc.cache.AccuweatherCache;
import lesson.http_jdbc.client.AccuweatherClient;
import lesson.http_jdbc.dao.CityRepository;
import lesson.http_jdbc.dao.CurrentConditionRepository;
import lesson.http_jdbc.mapper.CityMapper;
import lesson.http_jdbc.mapper.CurrentConditionResponseMapper;
import lesson.http_jdbc.service.AccuweatherService;
import lesson.http_jdbc.util.DbConnectionUtils;
import lombok.SneakyThrows;
import okhttp3.OkHttpClient;

import java.sql.Connection;
import java.sql.SQLException;

public class App {

    @SneakyThrows
    public static void main(final String[] args) {
        Class.forName("org.postgresql.Driver");

        OkHttpClient okHttpClient = new OkHttpClient();
        ObjectMapper objectMapper = new ObjectMapper();
        AccuweatherCache accuweatherCache = new AccuweatherCache();
        CityMapper cityMapper = new CityMapper();
        CurrentConditionResponseMapper conditionResponseMapper = new CurrentConditionResponseMapper();
        CityRepository cityRepository = new CityRepository(new CityMapper());
        CurrentConditionRepository currentConditionRepository = new CurrentConditionRepository();

        AccuweatherClient accuweatherClient = new AccuweatherClient(okHttpClient, objectMapper, accuweatherCache);
        AccuweatherService accuweatherService = new AccuweatherService(accuweatherClient, cityRepository,
                currentConditionRepository, cityMapper, conditionResponseMapper);

        dbInit();

        accuweatherService.run();
    }

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
            e.printStackTrace();
        }
    }
}
