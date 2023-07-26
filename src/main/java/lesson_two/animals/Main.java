package lesson_two.animals;

public class Main {
    public static void main(String[] args) {
        Cat[] catsArray = {
                new Cat("Murzik", 11),
                new Cat("Supchik", 15),
                new Cat("Blask", 7),
                new Cat("Barsik", 5)
        };
        Dog[] dogsArray = {
                new Dog("Bobik"),
                new Dog("Timati")
        };
        Plate plate = new Plate(100);
        plate.info();
        plate.addFood(10);
        plate.info();
        for (Cat cats : catsArray) {
            cats.eat(plate);
            plate.info();
            cats.catInfo();
        }
        for (Cat cats : catsArray) {
            if (cats.getAppetite() > 10) {
                cats.run(100);
            }
        }
        for (Dog dogs : dogsArray) {
            dogs.run(150);
        }
    }
}
