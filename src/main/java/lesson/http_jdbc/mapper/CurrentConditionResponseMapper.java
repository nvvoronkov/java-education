package lesson.http_jdbc.mapper;

import lesson.http_jdbc.model.dto.CurrentConditionResponse;
import lesson.http_jdbc.model.entity.CurrentConditionEntity;

public class CurrentConditionResponseMapper {
    public CurrentConditionEntity toEntity(final CurrentConditionResponse condition, final Long cityId) {
        return CurrentConditionEntity.builder()
                .temp(condition.getTemperature().getMetric().getValue())
                .cityId(cityId)
                .build();
    }
}
