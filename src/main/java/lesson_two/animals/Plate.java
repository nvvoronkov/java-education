package lesson_two.animals;

public class Plate {

    private int food;

    public void setFood(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int n) {
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

    public void addFood(int additive) {
        setFood(getFood() + additive);
    }
}
