package lesson.three.shapes;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ShapeManagerTest {
    private final ArrayList<Shape> shapes = new ArrayList<>(List.of(
            new Triangle(4.0, 5.0),
            new Circle(6.0),
            new Rectangle(2.0, 3.0)
    ));

    @Test
    void getTotalArea() {
        double expected = 129.097335529232557;
        double actual = 0;
        for (Shape shape : shapes) {
            actual += shape.getArea();
        }
        Assertions.assertThat(expected).isEqualTo(actual);
    }
}
