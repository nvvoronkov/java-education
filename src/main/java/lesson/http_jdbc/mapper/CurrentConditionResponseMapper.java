package lesson.http_jdbc.mapper;

import lesson.http_jdbc.model.dto.CurrentConditionResponse;
import lesson.http_jdbc.model.entity.CurrentConditionEntity;

//TODO https://mapstruct.org/
public class CurrentConditionResponseMapper {
    public CurrentConditionEntity toEntity(final CurrentConditionResponse condition, final Long cityKey) {
        return CurrentConditionEntity.builder()
                .temp(condition.getTemperature().getMetric().getValue())
                .cityId(cityKey)
                .build();
    }
}
