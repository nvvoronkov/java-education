import lesson_two.Cat;
import lesson_two.Plate;

public class Main {
    public static void main(String[] args) {
//        Byte[] bytes = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
//        TasksOne tasks = new TasksOne();
//        tasks.invertArray(bytes);
//        System.out.println(Arrays.toString(bytes));
//
//        int[] integers = new int[8];
//        System.out.println(Arrays.toString(tasks.addInteger(integers)));
//
//        int[] integers1 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
//        System.out.println(Arrays.toString(tasks.findLessSix(integers1)));
//
//        int[][] mas = new int[5][5];
//        tasks.fillDiagonal(mas);
//
//        System.out.println(tasks.findMinAndMax(integers1));
//
//        System.out.println(tasks.checkArray(integers1));
//
//        tasks.gameWithRandom();
//        tasks.fib(10);

        Cat[] catsArray = {
                new Cat("Murzik", 11),
                new Cat("Supchik", 15),
                new Cat("Blask", 7),
                new Cat("Barsik", 5)
        };
        Plate plate = new Plate(100);
        plate.info();
        plate.addFood(10);
        plate.info();
        for (Cat cats: catsArray) {
            cats.eat(plate);
            plate.info();
            cats.catInfo();
        }
    }
}
