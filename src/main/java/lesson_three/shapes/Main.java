package lesson_three.shapes;

public class Main {
    public static void main(String[] args) {
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
