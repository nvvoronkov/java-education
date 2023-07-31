package lesson_three.shapes;

import java.util.ArrayList;

public class ShapeManager {
    private final ArrayList<Shape> shapes = new ArrayList<>();

    public void addShape(Shape shape) {
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
