package lesson.three.task_two;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {
    private final Task task = new Task();

    @Test
    public void testInputArray() {
        String[][] array = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}};
        try {
            int expected = 136;
            int sum = task.inputArray(array);
            Assertions.assertThat(expected).isEqualTo(sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.getStackTrace();
        }
    }
}