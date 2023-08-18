package lesson.five;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Arrays;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Main {
    public static void main(final String[] args) {
        String[] arr = {"h", "e", "l", "l", "o"};
        int[] arrInt = {1, 2, 4, 6, 8, 9, 14, 15};
        Task task = new Task();
        System.out.println(Arrays.toString(task.reverseStringArray(arr)));
        System.out.println(task.hasPairWithSum(arrInt, 13));
    }
}
