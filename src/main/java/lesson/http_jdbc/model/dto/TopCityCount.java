package lesson.http_jdbc.model.dto;

import lombok.Getter;

import java.util.Arrays;
//почему это DTO?

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
