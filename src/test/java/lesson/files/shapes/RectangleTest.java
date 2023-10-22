package lesson.files.shapes;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RectangleTest {
    private final Shape rectangle = new Rectangle(5.0, 5.0);

    @Test
    void getArea() {
        double expected = 25.0;
        double actual = rectangle.getArea();
        Assertions.assertThat(expected).isEqualTo(actual);
    }
}
