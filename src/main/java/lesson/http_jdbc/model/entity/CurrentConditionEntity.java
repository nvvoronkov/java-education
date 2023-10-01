package lesson.http_jdbc.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CurrentConditionEntity {
    private Long id;
    private BigDecimal temp;
    private Long cityId;
}
