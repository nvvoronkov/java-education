package lesson.three.shapes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Triangle implements Shape {
    public static final double COEFFICIENT = 0.5;
    private double base;
    private double height;

    @Override
    public double getArea() {
        return height * base * COEFFICIENT;
    }

    @Override
    public String getInfo() {
        return "Triangle with base " + base + " and height " + height;
    }
}
