package lesson.two.animals;

public abstract class Animal {
    private static int count;
    public abstract void run(int distance);

    public abstract void swim(int distance);

    public Animal() {
        setCount();
    }

    public static void setCount() {
        Animal.count++;
    }

    public static int getCount() {
        return count;
    }
}
