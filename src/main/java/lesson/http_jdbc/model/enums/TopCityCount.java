package lesson.http_jdbc.model.enums;

import lombok.Getter;

@Getter
public enum TopCityCount {
    FIFTY(50),
    HUNDRED(100),
    HUNDRED_FIFTY(150);

    private final int value;

    TopCityCount(final int value) {
        this.value = value;
    }

}
