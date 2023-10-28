package lesson.http_jdbc.mapper;

import lesson.http_jdbc.model.dto.LocationsRoot;
import lesson.http_jdbc.model.entity.CityEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.sql.ResultSet;


//TODO https://mapstruct.org/
@Mapper
public interface CityMapper {
    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "key")
    @Mapping(target = "name", source = "englishName")
    CityEntity toEntity(LocationsRoot locationsRoot);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    CityEntity toEntity(ResultSet resultSet);
}
