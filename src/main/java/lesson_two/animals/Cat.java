package lesson_two.animals;

public class Cat extends Animal {

    private String name;
    private int appetite;
    private boolean satiety;
    private final int runDistance = 200;

    public Cat(String name, int appetite) {
        System.out.println(this);
        this.name = name;
        this.appetite = appetite;
    }

    public String getName() {
        return this.name;
    }

    public int getAppetite() {
        return appetite;
    }

    public boolean isSatiety() {
        return satiety;
    }

    public void setSatiety(boolean satiety) {
        this.satiety = satiety;
    }

    @Override
    public void run(int distance) {
        if (distance < runDistance) {
            System.out.println(getName() + " ran " + distance);
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("Cats cant swim");
    }

    public void eat(Plate p) {
        this.setSatiety(p.decreaseFood(this.appetite));
    }

    public static void eatStatic(Plate p, Cat cat) {
        cat.setSatiety(p.decreaseFood(cat.appetite));
    }

    public void catInfo() {
        System.out.println("cat " + getName() + " satiety: " + isSatiety());
    }

    public void testCat() {
        System.out.println("mur mur");
    }
}
