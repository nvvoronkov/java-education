package lesson.http_jdbc.mapper;

import lesson.http_jdbc.model.dto.CurrentConditionResponse;
import lesson.http_jdbc.model.entity.CurrentConditionEntity;

public class CurrentConditionResponseMapper {
    public CurrentConditionEntity toEntity(final CurrentConditionResponse condition, final Long cityKey) {
        return CurrentConditionEntity.builder()
                .temp(condition.getTemperature().getMetric().getValue())
                .cityKey(cityKey)
                .build();
    }
}
