package lessonOne;

import java.util.Random;
import java.util.Scanner;

public class Tasks {
    public String[] invertMassive(Byte[] inputMassive) {
        StringBuilder rezult = new StringBuilder();
        String rezultString;
        for (Byte b : inputMassive) {
            if (b == 1) {
                rezult.append(0);
            } else {
                rezult.append(1);
            }
        }
        rezultString = rezult.toString();
        return rezultString.split("");
    }

    public Integer[] addInteger(Integer[] input) {
        for (int i = 0; i < input.length; i++) {
            input[i] = i * 3;
        }
        return input;
    }

    public Integer[] findLessSix(Integer[] integers) {
        for (int i = 0; i < integers.length; i++) {
            if (integers[i] < 6) {
                integers[i] *= 2;
            }
        }
        return integers;
    }

    public void fillDiagonal(int[][] mas) {
        for (int i = 0; i < mas.length; i++) {
            mas[i][i] = 1;
            mas[i][mas.length - 1 - i] = 1;
        }
        for (int[] ints : mas) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    public String findMinAndMax(Integer[] massive) {
        int min = 0;
        int max = 0;
        for (Integer integers : massive) {
            if (max > integers) {
                max = integers;
            }
            if (min < integers) {
                min = integers;
            }
        }
        return "минимум: " + min + "\nмаксимум: " + max;
    }

    public boolean cheakMaassive(Integer[] massive) {
        int right = 0;
        int left = 0;
        for (Integer mas : massive) {
            right += mas;
        }
        for (Integer mas : massive) {
            left += mas;
            right -= mas;
            if (left == right) {
                return true;
            }
        }
        return false;
    }

    public boolean randomGame() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int userInt = scanner.nextInt();
        return userInt == random.nextInt(9);
    }

    public void printMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите число от 0 до 9");
            for (int i = 3; i >= 0; i--) {
                if (randomGame()) {
                    System.out.println("Вы угадали!");
                    break;
                } else {
                    System.out.println("Неправильно(\nОсталось " + (i - 1) + " попыток!");
                }
            }
        }
    }
}
