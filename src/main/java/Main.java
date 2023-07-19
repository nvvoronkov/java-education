import lessonOne.Tasks;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Byte[] massive = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        Tasks tasks = new Tasks();
        System.out.println(Arrays.toString(tasks.invertMassive(massive)));

        Integer[] integers = new Integer[8];
        System.out.println(Arrays.toString(tasks.addInteger(integers)));

        Integer[] integers1 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(tasks.findLessSix(integers1)));

        int[][] mas = new int[5][5];
        tasks.fillDiagonal(mas);

        System.out.println(tasks.findMinAndMax(integers1));

        System.out.println(tasks.cheakMaassive(integers1));

        Scanner scanner = new Scanner(System.in);
        tasks.printMenu();
        System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
        switch (scanner.nextInt()) {
            case (1):
                tasks.printMenu();
                break;
            case (2):
                break;
        }
    }
}
