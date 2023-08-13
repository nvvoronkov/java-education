package lesson.four.task;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Box<T extends Fruit> {
    private final List<Fruit> boxOfFruits = new ArrayList<>();

    public double getWeight() {
        if (boxOfFruits.size() == 0) {
            return 0;
        }
        return boxOfFruits.size() * fruit.getFruitWeight();
    }

    public void addFruit(T fruit) {
        boxOfFruits.add(fruit);
    }

    public boolean compare(Box<?> box) {
        return this.getWeight() == box.getWeight();
    }

    public void transfer(Box<T> anotherBox) {
        if (this == anotherBox) {
            return;
        }
        if (boxOfFruits.size() == 0) {
            return;
        }
        if (boxOfFruits.get(0).getClass() != anotherBox.boxOfFruits.get(0).getClass()) {
            return;
        }
        anotherBox.boxOfFruits.addAll(boxOfFruits);
        boxOfFruits.clear();
    }
}
