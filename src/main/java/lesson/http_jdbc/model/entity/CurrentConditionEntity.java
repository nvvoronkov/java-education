package lesson.http_jdbc.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CurrentConditionEntity {
    private Long id;
    private Double temp;
    private Long cityKey;
}
