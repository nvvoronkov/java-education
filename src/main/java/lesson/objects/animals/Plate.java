package lesson.objects.animals;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Plate {

    private int food;

    public Plate(final int food) {
        this.food = food;
    }

    public boolean decreaseFood(final int n) {
        if (food >= n) {
            food -= n;
            return true;
        } else {
            return false;
        }
    }

    public void info() {
        System.out.println("plate: " + food);
    }

    public void addFood(final int additive) {
        setFood(getFood() + additive);
    }
}
