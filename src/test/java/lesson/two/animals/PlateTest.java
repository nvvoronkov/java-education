package lesson.two.animals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlateTest {

    @Test
    void decreaseFood_WithEnoughFood_ShouldDecreaseFoodAndReturnTrue() {
        int food = 10;
        Plate plate = new Plate(food);
        boolean result = plate.decreaseFood(5);
        int expectedFood = 5;
        int actualFood = plate.getFood();
        assertTrue(result);
        org.assertj.core.api.Assertions.assertThat(expectedFood).isEqualTo(actualFood);
    }
    @Test
    void decreaseFoodWithNotEnoughFoodShouldNotDecreaseFoodAndReturnFalse() {
        int food = 3;
        Plate plate = new Plate(food);
        boolean result = plate.decreaseFood(5);
        int expectedFood = 3;
        int actualFood = plate.getFood();
        assertFalse(result);
        org.assertj.core.api.Assertions.assertThat(expectedFood).isEqualTo(actualFood);
    }
    @Test
    void addFoodShouldIncreaseFoodByAdditive() {
        int food = 5;
        int additive = 3;
        Plate plate = new Plate(food);
        plate.addFood(additive);
        int expectedFood = 8;
        int actualFood = plate.getFood();
        org.assertj.core.api.Assertions.assertThat(expectedFood).isEqualTo(actualFood);
    }
}
