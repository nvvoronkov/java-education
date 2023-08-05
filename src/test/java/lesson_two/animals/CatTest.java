package lesson_two.animals;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CatTest {
    @Test
    void run_WithDistanceLessThanRunDistance_ShouldPrintRunMessage() {
        Cat cat = new Cat("Tom", 5);
        String expectedOutput = "Tom ran 150";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        cat.run(150);
        String actualOutput = outputStream.toString().trim();
        org.assertj.core.api.Assertions.assertThat(expectedOutput).isEqualTo(actualOutput);
    }
    @Test
    void eat_WithEnoughFood_ShouldSetSatietyToTrue() {
        Cat cat = new Cat("Tom", 5);
        Plate plate = new Plate(10);
        cat.eat(plate);
        assertTrue(cat.isSatiety());
        Assertions.assertThat(cat.isSatiety()).isFalse();
    }
    @Test
    void eat_WithNotEnoughFood_ShouldSetSatietyToFalse() {
        Cat cat = new Cat("Tom", 10);
        Plate plate = new Plate(5);
        cat.eat(plate);
        Assertions.assertThat(cat.isSatiety()).isFalse();
    }
    @Test
    void catInfo_ShouldPrintCatInfo() {
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