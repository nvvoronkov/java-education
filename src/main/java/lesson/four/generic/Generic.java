package lesson.four.generic;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Generic {
    public static void main(String[] args) {
        final Map<String, Admin> integerUserMap = new Map<>();

    }

    public static <T> void swap(T[] t, int i, int j) {
        T temp = t[i];
        t[i] = t[j];
        t[j] = temp;
    }

}
