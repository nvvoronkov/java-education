package lesson_three.shapes;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class TriangleTest {
    Shape triangle = new Triangle(4.0, 2.0);

    @Test
    void getArea() {
        double expected = 4.0;
        double actual = triangle.getArea();
        Assertions.assertThat(expected).isEqualTo(actual);
    }
}