package lesson.http.cache;

import lesson.http.model.LocationsRoot;
import lesson.http.model.TopCityCount;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class AccuweatherCache {
    private final Map<TopCityCount, LocationsRoot[]> cache = new HashMap<>();

    public LocationsRoot[] save(final TopCityCount topCityCount, final LocationsRoot[] locationsRoots) {
        return cache.put(topCityCount, locationsRoots);
    }

    public LocationsRoot[] get(final TopCityCount topCityCount) {
        return cache.get(topCityCount);
    }

    public void clean() {
        cache.clear();
    }
}
