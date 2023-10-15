package lesson.http_jdbc.mapper;

import lesson.http_jdbc.model.dto.LocationsRoot;
import lesson.http_jdbc.model.entity.CityEntity;

import java.sql.ResultSet;
import java.sql.SQLException;


//TODO https://mapstruct.org/
public class CityMapper {
    public CityEntity toEntity(final LocationsRoot locationsRoot) {
        return CityEntity.builder()
                .id(Long.valueOf(locationsRoot.getKey()))
                .name(locationsRoot.getEnglishName())
                .build();
    }

    public CityEntity toEntity(final ResultSet resultSet) throws SQLException {
        return CityEntity.builder()
                .id(resultSet.getLong("id"))
                .name(resultSet.getString("name"))
                .build();
    }

}
