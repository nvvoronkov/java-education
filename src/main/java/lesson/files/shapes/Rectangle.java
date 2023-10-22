package lesson.files.shapes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Rectangle implements Shape {
    private double width;
    private double height;


    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public String getInfo() {
        return "Rectangle with width " + width + " and height " + height;
    }
}
