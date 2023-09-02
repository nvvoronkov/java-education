package lesson.http.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import lesson.http.model.LocationsRoot;
import lesson.http.model.TopCityCount;
import lombok.RequiredArgsConstructor;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

//TODO https://developer.accuweather.com/accuweather-current-conditions-api/apis/get/currentconditions/v1/%7BlocationKey%7D
@RequiredArgsConstructor
public class AccuweatherClient {
    private static final String URL = "http://dataservice.accuweather.com";
    private static final String API_KEY = "kRK8UAPHaOphrB82Ida62hMIdFnt36yB";
    private static final String API_KEY_NIKITA = "rJYdO0tH99qVeV0XeyWQR8Gd9h8cHGbJ";

    private final OkHttpClient okHttpClient;
    private final ObjectMapper objectMapper;

    public LocationsRoot[] getTopCities(final TopCityCount topCityCount) {
        var url = HttpUrl.parse(URL)
                .newBuilder()
                .addPathSegment("locations")
                .addPathSegment("v1")
                .addPathSegment("topcities")
                .addPathSegment(String.valueOf(topCityCount.getValue()))
                .addQueryParameter("apikey", API_KEY_NIKITA)
                .build()
                .toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        System.out.println("Sending rq... " + request);
        try (Response response = okHttpClient.newCall(request).execute()) {
            System.out.println("Received rs... " + response);
            String json = response.body().string();
            return objectMapper.readValue(json, LocationsRoot[].class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
