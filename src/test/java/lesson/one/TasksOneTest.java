package lesson.one;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class TasksOneTest {
    private final TasksOne tasks = new TasksOne();
    @Test
    public void testInvertArray() {
        Byte[] inputArray = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        Byte[] expected = {0, 0, 1, 1, 0, 1, 0, 0, 1, 1};
        tasks.invertArray(inputArray);
        Assertions.assertThat(expected).isEqualTo(inputArray);
    }

    @Test
    public void testAddInteger() {
        int arrayLength = 8;
        int[] input = new int[arrayLength];
        int[] expected = {0, 3, 6, 9, 12, 15, 18, 21};
        int[] actual = tasks.addInteger(input);
        Assertions.assertThat(expected).isEqualTo(actual);
    }

    @Test
    public void testFindLessSix() {
        int[] integers = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int[] expected = {2, 10, 6, 4, 11, 8, 10, 4, 8, 8, 9, 2};
        int[] actual = tasks.findLessSix(integers);
        Assertions.assertThat(expected).isEqualTo(actual);
    }

    @Test
    public void testFillDiagonal() {
        int[][] arr = new int[5][5];
        int[][] expected = {
                {1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0},
                {0, 0, 1, 0, 0},
                {0, 1, 0, 1, 0},
                {1, 0, 0, 0, 1}
        };
        tasks.fillDiagonal(arr);
        Assertions.assertThat(expected).isEqualTo(arr);
    }

    @Test
    public void testFindMinAndMax() {
        int[] massive = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int[] expected = {1, 11};
        int[] actual = tasks.findMinAndMax(massive);
        Assertions.assertThat(expected).isEqualTo(actual);
    }

    @Test
    public void testCheckArray() {
        int[] massive1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] massive2 = {1, 2, 3, 4, 5, 6, 8, 8, 9};
        boolean expected1 = true;
        boolean expected2 = false;
        boolean actual1 = tasks.checkArray(massive1);
        boolean actual2 = tasks.checkArray(massive2);
        Assertions.assertThat(expected1).isEqualTo(actual1);
        Assertions.assertThat(expected2).isEqualTo(actual2);
    }

    @Test
    public void testGameWithRandom() {
        String input = "5\n0\n1\n1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        tasks.gameWithRandom();
    }
}