package lesson.http_jdbc.mapper;

import lesson.http_jdbc.model.dto.CurrentConditionResponse;
import lesson.http_jdbc.model.entity.CurrentConditionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CurrentConditionResponseMapper {
    CurrentConditionResponseMapper INSTANCE = Mappers.getMapper(CurrentConditionResponseMapper.class);

    @Mapping(target = "temp", source = "temperature.metric.value")
    @Mapping(target = "cityId", source = "cityKey")
    CurrentConditionEntity toEntity(CurrentConditionResponse condition, Long cityKey);
}
