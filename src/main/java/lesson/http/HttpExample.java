package lesson.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import lesson.http.cache.AccuweatherCache;
import lesson.http.client.AccuweatherClient;
import lesson.http.service.AccuweatherService;
import lombok.SneakyThrows;
import okhttp3.OkHttpClient;

public class HttpExample {

    @SneakyThrows
    public static void main(final String[] args) {
        OkHttpClient okHttpClient = new OkHttpClient();
        ObjectMapper objectMapper = new ObjectMapper();
        AccuweatherCache accuweatherCache = new AccuweatherCache();

        AccuweatherClient accuweatherClient = new AccuweatherClient(okHttpClient, objectMapper, accuweatherCache);
        AccuweatherService accuweatherService = new AccuweatherService(accuweatherClient);

        accuweatherService.run();

    }
}
