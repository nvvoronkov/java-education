package lesson.http_jdbc.mapper;

import lesson.http_jdbc.model.dto.LocationsRoot;
import lesson.http_jdbc.model.entity.CityEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.sql.ResultSet;
import java.sql.SQLException;


//TODO https://mapstruct.org/
@Mapper
public interface CityMapper {
    CityMapper instance = Mappers.getMapper(CityMapper.class);

    @Mapping(source = "key", target = "id")
    @Mapping(source = "englishName", target = "name")
    CityEntity toEntity(LocationsRoot locationsRoot);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    CityEntity toEntity(ResultSet resultSet) throws SQLException;
}