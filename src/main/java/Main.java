import lesson.one.TasksOne;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Arrays;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
final public class Main {
    public static void main(final String[] args) {
        Byte[] bytes = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        TasksOne tasks = new TasksOne();
        tasks.invertArray(bytes);
        System.out.println(Arrays.toString(bytes));

        int[] integers = new int[8];
        System.out.println(Arrays.toString(tasks.addInteger(integers)));

        int[] integers1 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(tasks.findLessSix(integers1)));

        int[][] mas = new int[5][5];
        tasks.fillDiagonal(mas);

        System.out.println(Arrays.toString(tasks.findMinAndMax(integers1)));

        System.out.println(tasks.checkArray(integers1));

        tasks.gameWithRandom();
        tasks.fib(10);
    }
}
