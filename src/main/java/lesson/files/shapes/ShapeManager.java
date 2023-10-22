package lesson.files.shapes;

import java.util.LinkedList;
import java.util.List;

public class ShapeManager {
    private final List<Shape> shapes = new LinkedList<>();

    public void addShape(final Shape shape) {
        shapes.add(shape);
    }

    public double getTotalArea() {
        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.getArea();
        }
        return totalArea;
    }

    public void printInfo() {
        for (Shape shape : shapes) {
            System.out.println(shape.getInfo() + ", area = " + shape.getArea());
        }
    }
}
