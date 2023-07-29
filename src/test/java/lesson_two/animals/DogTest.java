package lesson_two.animals;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class DogTest {

    @Test
    void run() {
    }

    @Test
    void swim() {
    }

    @Test
    void run_WithValidDistance_ShouldPrintCorrectMessage() {
        Dog dog = new Dog("Buddy");
        String expected = "Buddy ran 300m";
        // Предполагаем, что метод run будет выводить сообщение в консоль
        // Мы можем использовать ByteArrayOutputStream для перехвата вывода
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        dog.run(300);
        String actual = outputStream.toString().trim();
        org.assertj.core.api.Assertions.assertThat(expected).isEqualTo(actual);
    }
    @Test
    void run_WithInvalidDistance_ShouldNotPrintMessage() {
        Dog dog = new Dog("Buddy");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        dog.run(700);
        String actual = outputStream.toString().trim();
        org.assertj.core.api.Assertions.assertThat("").isEqualTo(actual);
    }
    @Test
    void swim_WithValidDistance_ShouldPrintCorrectMessage() {
        Dog dog = new Dog("Buddy");
        String expected = "Buddy swam 8m";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        dog.swim(8);
        String actual = outputStream.toString().trim();
        org.assertj.core.api.Assertions.assertThat(expected).isEqualTo(actual);

    }
    @Test
    void swim_WithInvalidDistance_ShouldNotPrintMessage() {
        Dog dog = new Dog("Buddy");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        dog.swim(15);
        String actual = outputStream.toString().trim();
        org.assertj.core.api.Assertions.assertThat("").isEqualTo(actual);
    }
}