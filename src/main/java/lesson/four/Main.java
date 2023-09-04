package lesson.four;

import java.util.Arrays;

public class Main {
    public static void main(final String[] args) {
        String[] names = {"Alice", "Bob", "Charlie"};
        swapElements(names, 0, 2);
        System.out.println(Arrays.toString(names));

    }

    public static <T> void swapElements(final T[] array, final int index1, final int index2) {
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
