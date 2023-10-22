package lesson.files.shapes;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Main {
    public static void main(final String[] args) {
        ShapeManager manager = new ShapeManager();

        Shape circle = new Circle(12);
        Shape rectangle = new Rectangle(7, 10);
        Shape triangle = new Triangle(10, 5);

        manager.addShape(circle);
        manager.addShape(rectangle);
        manager.addShape(triangle);

        manager.printInfo();
        System.out.println("Total area: " + manager.getTotalArea());
    }
}
