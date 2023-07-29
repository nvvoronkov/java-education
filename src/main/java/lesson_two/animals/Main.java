package lesson_two.animals;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Animal animal;
        if (new Random().nextBoolean()) {
            animal = new CustomDog("1");
        } else {
            animal = new Cat("cat", 1);
        }

        if (animal instanceof Cat cat) {
            cat.testCat();
        }

        animal.run(12);
    }
}
