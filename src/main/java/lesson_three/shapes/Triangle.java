package lesson_three.shapes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Triangle implements Shape {
    private double base;
    private double height;

    @Override
    public double getArea() {
        return height * base * 0.5;
    }

    @Override
    public String getInfo() {
        return "Triangle with base " + base + " and height " + height;
    }
}
