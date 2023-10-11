package lesson.http_jdbc.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lesson.http_jdbc.cache.AccuweatherCache;
import lesson.http_jdbc.model.dto.CurrentConditionResponse;
import lesson.http_jdbc.model.dto.LocationsRoot;
import lesson.http_jdbc.model.dto.TopCityCount;
import lesson.http_jdbc.util.ReadPropertiesUtils;
import lombok.RequiredArgsConstructor;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Objects;

@RequiredArgsConstructor
public class AccuweatherClient {
    private static final String URL = "http://dataservice.accuweather.com";

    private final String apiKey = ReadPropertiesUtils.readProperty("apikey");

    private final OkHttpClient okHttpClient;
    private final ObjectMapper objectMapper;
    private final AccuweatherCache accuweatherCache;

    public LocationsRoot[] getTopCities(final TopCityCount topCityCount) {
        if (accuweatherCache.getCache().containsKey(topCityCount)) {
            return accuweatherCache.get(topCityCount);
        }

        var url = Objects.requireNonNull(HttpUrl.parse(URL))
                .newBuilder()
                .addPathSegment("locations")
                .addPathSegment("v1")
                .addPathSegment("topcities")
                .addPathSegment(String.valueOf(topCityCount.getValue()))
                .addQueryParameter("apikey", apiKey)
                .build()
                .toString();

        TypeReference<LocationsRoot[]> typeReference = new TypeReference<>() {
        };
        LocationsRoot[] locationsRoots = call(url, typeReference);
        accuweatherCache.save(topCityCount, locationsRoots);
        return locationsRoots;
    }

    //TODO: Реализовать сохранение истории получениы current conditiion
    public CurrentConditionResponse[] getCurrentCondition(final String key) {
        var url = Objects.requireNonNull(HttpUrl.parse(URL))
                .newBuilder()
                .addPathSegment("currentconditions")
                .addPathSegment("v1")
                .addPathSegment(key)
                .addQueryParameter("apikey", apiKey)
                .build()
                .toString();
        TypeReference<CurrentConditionResponse[]> typeReference = new TypeReference<>() {
        };
        return call(url, typeReference);
    }

    private <T> T[] call(final String url, final TypeReference<T[]> typeReference) {
        Request request = new Request.Builder()
                .url(url)
                .build();

        System.out.println("Sending rq... " + request);
        try (Response response = okHttpClient.newCall(request).execute()) {
            System.out.println("Received rs... " + response);
            assert response.body() != null;
            String json = response.body().string();
            return objectMapper.readValue(json, typeReference);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
