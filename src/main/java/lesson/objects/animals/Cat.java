package lesson.objects.animals;

import lombok.Getter;

@Getter
public class Cat extends Animal {

    private final String name;
    private final int appetite;
    private boolean satiety;
    private static final int RUN_DISTANCE = 200;
    private static int countCat;

    public Cat(final String name, final int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void setSatiety(final boolean satiety) {
        this.satiety = satiety;
    }

    @Override
    public void run(final int distance) {
        if (distance < RUN_DISTANCE) {
            System.out.println(getName() + " ran " + distance);
        }
    }

    @Override
    public void swim(final int distance) {
        System.out.println("Cats cant swim");
    }

    public void eat(final Plate p) {
        this.setSatiety(p.decreaseFood(this.appetite));
    }

    public static void eatStatic(final Plate p, final Cat cat) {
        cat.setSatiety(p.decreaseFood(cat.appetite));
    }

    public void catInfo() {
        System.out.println("cat " + getName() + " satiety: " + isSatiety());
    }

    public void testCat() {
        System.out.println("mur mur");
    }
}
