package lesson.four.task;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Orange extends Fruit {
    private final double fruitWeight = 1.5;
}
