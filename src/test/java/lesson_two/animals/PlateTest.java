package lesson_two.animals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlateTest {

    @Test
    void decreaseFood_WithEnoughFood_ShouldDecreaseFoodAndReturnTrue() {
        Plate plate = new Plate(10);
        boolean result = plate.decreaseFood(5);
        int expectedFood = 5;
        int actualFood = plate.getFood();
        assertTrue(result);
        org.assertj.core.api.Assertions.assertThat(expectedFood).isEqualTo(actualFood);
    }
    @Test
    void decreaseFood_WithNotEnoughFood_ShouldNotDecreaseFoodAndReturnFalse() {
        Plate plate = new Plate(3);
        boolean result = plate.decreaseFood(5);
        int expectedFood = 3;
        int actualFood = plate.getFood();
        assertFalse(result);
        org.assertj.core.api.Assertions.assertThat(expectedFood).isEqualTo(actualFood);
    }
    @Test
    void addFood_ShouldIncreaseFoodByAdditive() {
        Plate plate = new Plate(5);
        plate.addFood(3);
        int expectedFood = 8;
        int actualFood = plate.getFood();
        org.assertj.core.api.Assertions.assertThat(expectedFood).isEqualTo(actualFood);
    }
}