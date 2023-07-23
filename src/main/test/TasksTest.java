import lessonOne.Tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TasksTest {
    private Tasks tasks;

    @BeforeEach
    public void setUp() {
        tasks = new Tasks();
    }

    @Test
    public void testInvertMassive() {
        Byte[] inputMassive = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        String[] expected = {"0", "0", "1", "1", "0", "1", "0", "0", "1", "1"};
        String[] actual = tasks.invertMassive(inputMassive);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddInteger() {
        Integer[] input = new Integer[8];
        Integer[] expected = {0, 3, 6, 9, 12, 15, 18, 21};
        Integer[] actual = tasks.addInteger(input);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindLessSix() {
        Integer[] integers = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        Integer[] expected = {2, 10, 6, 4, 11, 8, 10, 4, 8, 8, 9, 2};
        Integer[] actual = tasks.findLessSix(integers);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFillDiagonal() {
        int[][] mas = new int[5][5];
        int[][] expected = {
                {1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0},
                {0, 0, 1, 0, 0},
                {0, 1, 0, 1, 0},
                {1, 0, 0, 0, 1}
        };
        tasks.fillDiagonal(mas);
        Assertions.assertTrue(Arrays.deepEquals(expected, mas));
    }

    @Test
    public void testFindMinAndMax() {
        Integer[] massive = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        String expected = "минимум: 1\nмаксимум: 11";
        String actual = tasks.findMinAndMax(massive);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testCheakMaassive() {
        Integer[] massive1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] massive2 = {1, 2, 3, 4, 5, 6, 8, 8, 9};
        boolean expected1 = true;
        boolean expected2 = false;
        boolean actual1 = tasks.cheakMaassive(massive1);
        boolean actual2 = tasks.cheakMaassive(massive2);
        Assertions.assertEquals(expected1, actual1);
        Assertions.assertEquals(expected2, actual2);
    }
    // Additional test for printMenu method can be added, but it requires user input
    // which is not suitable for automated unit testing.
}