package lesson.two.animals;

public class Dog extends Animal {
    private final int swimDistance = 10;
    private final int runDistance = 500;
    private String name;

    private static int count;

    public Dog(final String name) {
        super();
        count++;
        this.name = name;
    }

    public static int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run(final int distance) {
        if (distance < runDistance) {
            System.out.println(getName() + " ran " + distance + "m");
        }
    }

    @Override
    public void swim(final int distance) {
        if (distance < swimDistance) {
            System.out.println(getName() + " swam " + distance + "m");
        }
    }
}
