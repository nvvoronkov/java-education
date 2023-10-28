package lesson.generics.generic;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Generic {
    public static <T> void swap(final T[] t, final int i, final int j) {
        T temp = t[i];
        t[i] = t[j];
        t[j] = temp;
    }
}
