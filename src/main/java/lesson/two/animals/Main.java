package lesson.two.animals;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class Main {

    public static void main(final String[] args) {
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
