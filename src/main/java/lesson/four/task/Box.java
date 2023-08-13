package lesson.four.task;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private final List<T> fruits = new ArrayList<>();

    public List<T> getFruits() {
        return new ArrayList<>(fruits);
    }

    public double getWeight() {
        return fruits.stream()
                .mapToDouble(Fruit::getWeight)
                .sum();
    }

    public void addFruit(final T fruit) {
        if (fruits.size() < 3) {
            fruits.add(fruit);
        }
        System.out.println("Not space!");
    }

    public boolean compare(final Box<?> box) {
        return this.getWeight() == box.getWeight();
    }

    public void transferInto(final Box<T> anotherBox) {
        anotherBox.fruits.addAll(fruits);
        fruits.clear();
    }
}
