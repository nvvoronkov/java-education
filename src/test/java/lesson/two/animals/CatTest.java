package lesson.two.animals;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CatTest {
    @Test
    void runWithDistanceLessThanRunDistanceShouldPrintRunMessage() {
        int distance = 150;
        Cat cat = new Cat("Tom", 5);
        String expectedOutput = "Tom ran 150";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        cat.run(distance);
        String actualOutput = outputStream.toString().trim();
        org.assertj.core.api.Assertions.assertThat(expectedOutput).isEqualTo(actualOutput);
    }
    @Test
    void eatWithEnoughFoodShouldSetSatietyToTrue() {
        int food = 10;
        Cat cat = new Cat("Tom", 5);
        Plate plate = new Plate(food);
        cat.eat(plate);
        assertTrue(cat.isSatiety());
        Assertions.assertThat(cat.isSatiety()).isFalse();
    }
    @Test
    void eatWithNotEnoughFoodShouldSetSatietyToFalse() {
        int food = 5;
        Cat cat = new Cat("Tom", 10);
        Plate plate = new Plate(food);
        cat.eat(plate);
        Assertions.assertThat(cat.isSatiety()).isFalse();
    }
    @Test
    void catInfoShouldPrintCatInfo() {
        Cat cat = new Cat("Tom", 5);
        cat.setSatiety(true);
        String expectedOutput = "cat Tom satiety: true";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        cat.catInfo();
        String actualOutput = outputStream.toString().trim();
        org.assertj.core.api.Assertions.assertThat(expectedOutput).isEqualTo(actualOutput);
    }
}