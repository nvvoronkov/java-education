package lesson_two.animals;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Animal animal;
        if (new Random().nextBoolean()) {
            animal = new Cat("cat", 1);
        } else {
            animal = new Cat("cat", 1);
        }

        //Cat.getStaticName();

        if (animal instanceof Cat cat) {
            String name = cat.getName();
            cat.testCat();
        }

        animal.run(12);
    }
}
