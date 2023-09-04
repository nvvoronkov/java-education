package lesson.http.model;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum TopCityCount {
    FIFTY(50),
    HUNDRED(100),
    HUNDRED_FIFTY(150);

    private final int value;

    TopCityCount(final int value) {
        this.value = value;
    }

    public static TopCityCount getTopCityCountByValue(final int value) {
        return Arrays.stream(values())
                .filter(topCityCount -> topCityCount.getValue() == value)
                .findFirst()
                .orElseThrow();
    }
}
