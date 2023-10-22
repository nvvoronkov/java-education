package lesson.files.shapes;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CircleTest {
    private final Shape circle = new Circle(12.0);

    @Test
    void getArea() {
        double expected = 452.3893421169302;
        double actual = circle.getArea();
        Assertions.assertThat(expected).isEqualTo(actual);
    }
}
