package lesson.http_jdbc.mapper;

import lesson.http_jdbc.model.dto.LocationsRoot;
import lesson.http_jdbc.model.entity.CityEntity;


public class CityMapper {
    public CityEntity toEntity(final LocationsRoot locationsRoot) {
        return CityEntity.builder()
                .id(Long.valueOf(locationsRoot.getKey()))
                .name(locationsRoot.getEnglishName())
                .build();
    }
}
