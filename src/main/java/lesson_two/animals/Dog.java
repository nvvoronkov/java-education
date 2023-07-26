package lesson_two.animals;

public class Dog extends Animal {
    private String name;
    private final int swimDistance = 10;
    private final int runDistance = 500;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run(int distance) {
        if (distance < runDistance) {
            System.out.println(getName() + " ran " + distance + "m");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance < swimDistance) {
            System.out.println(getName() + " swam " + distance + "m");
        }
    }
}
