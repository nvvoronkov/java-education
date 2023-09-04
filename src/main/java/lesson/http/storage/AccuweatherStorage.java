package lesson.http.storage;

import lesson.http.model.LocationsRoot;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class AccuweatherStorage {
    private List<LocationsRoot> cache = new ArrayList<>();
    public void save(final LocationsRoot[] locationsRoots) {
        cache.addAll(Arrays.asList(locationsRoots));
    }

    public LocationsRoot[] load() {
        return cache.toArray(new LocationsRoot[0]);
    }

    public void clean(final List<LocationsRoot> cache) {
        cache.clear();
    }
}
