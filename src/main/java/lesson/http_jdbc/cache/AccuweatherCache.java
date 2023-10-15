package lesson.http_jdbc.cache;

import lesson.http_jdbc.model.dto.LocationsRoot;
import lesson.http_jdbc.model.enums.TopCityCount;
import lombok.Data;

import java.util.EnumMap;

@Data
public class AccuweatherCache {
    private final EnumMap<TopCityCount, LocationsRoot[]> cache = new EnumMap<>(TopCityCount.class);

    public void save(final TopCityCount topCityCount, final LocationsRoot[] locationsRoots) {
        cache.put(topCityCount, locationsRoots);
    }

    public LocationsRoot[] get(final TopCityCount topCityCount) {
        return cache.get(topCityCount);
    }

    public void clean() {
        cache.clear();
    }
}
