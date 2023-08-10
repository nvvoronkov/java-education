package lesson.two.animals;

public class Plate {

    private int food;

    public void setFood(final int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

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
