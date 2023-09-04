package lesson.two.animals;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class DogTest {

    @Test
    void run() {
    }

    @Test
    void swim() {
    }

    @Test
    void runWithValidDistanceShouldPrintCorrectMessage() {
        int distance = 300;
        Dog dog = new Dog("Buddy");
        String expected = "Buddy ran 300m";
        // Предполагаем, что метод run будет выводить сообщение в консоль
        // Мы можем использовать ByteArrayOutputStream для перехвата вывода
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        dog.run(distance);
        String actual = outputStream.toString().trim();
        org.assertj.core.api.Assertions.assertThat(expected).isEqualTo(actual);
    }
    @Test
    void runWithInvalidDistanceShouldNotPrintMessage() {
        int distance = 700;
        Dog dog = new Dog("Buddy");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        dog.run(distance);
        String actual = outputStream.toString().trim();
        org.assertj.core.api.Assertions.assertThat("").isEqualTo(actual);
    }
    @Test
    void swimWithValidDistanceShouldPrintCorrectMessage() {
        int distance = 8;
        Dog dog = new Dog("Buddy");
        String expected = "Buddy swam 8m";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        dog.swim(distance);
        String actual = outputStream.toString().trim();
        org.assertj.core.api.Assertions.assertThat(expected).isEqualTo(actual);

    }
    @Test
    void swimWithInvalidDistanceShouldNotPrintMessage() {
        int distance = 15;
        Dog dog = new Dog("Buddy");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        dog.swim(distance);
        String actual = outputStream.toString().trim();
        org.assertj.core.api.Assertions.assertThat("").isEqualTo(actual);
    }
}
