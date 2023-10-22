package lesson.http_jdbc.mapper;

import lesson.http_jdbc.model.dto.CurrentConditionResponse;
import lesson.http_jdbc.model.entity.CurrentConditionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


//TODO https://mapstruct.org/
@Mapper
public interface CurrentConditionResponseMapper {
    CurrentConditionResponseMapper instance = Mapper.getMapper(CurrentConditionResponseMapper.class);

    @Mapping(source = "value", target = "temp")
    @Mapping(source = "key", target = "cityId")
    CurrentConditionEntity toEntity(CurrentConditionResponse condition);
}
