package lesson.one;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TasksOne {
    public void invertArray(final Byte[] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] == 1) {
                inputArray[i] = 0;
            } else {
                inputArray[i] = 1;
            }
        }
    }

    public int[] addInteger(final int[] input) {
        final int coefficient = 3;
        for (int i = 0; i < input.length; i++) {
            input[i] = i * coefficient;
        }
        return input;
    }

    public int[] findLessSix(final int[] integers) {
        final int coefficient = 6;
        for (int i = 0; i < integers.length; i++) {
            if (integers[i] < coefficient) {
                integers[i] *= 2;
            }
        }
        return integers;
    }

    public void fillDiagonal(final int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = 1;
            arr[i][arr.length - 1 - i] = 1;
        }
        System.out.println(Arrays.deepToString(arr));
    }

    public int[] findMinAndMax(final int[] array) {
        int min = 0;
        int max = 0;
        for (int integers : array) {
            if (max > integers) {
                max = integers;
            }
            if (min < integers) {
                min = integers;
            }
        }
        return new int[]{min, max};
    }

    public boolean checkArray(final int[] array) {
        int right = 0;
        int left = 0;
        for (int arr : array) {
            right += arr;
        }
        for (int arr : array) {
            left += arr;
            right -= arr;
            if (left == right) {
                return true;
            }
        }
        return false;
    }

    public void gameWithRandom() {
        Scanner scanner = new Scanner(System.in);
        int attemptsLeft = 3;
        Random random = new Random();
        final int level = 10;
        int randomNumber = random.nextInt(level);

        while (true) {
            while (attemptsLeft > 0) {
                System.out.println("Введите число от 0 до 9");
                int userNumber = scanner.nextInt();
                if (userNumber == randomNumber) {
                    System.out.println("Вы угадали!");
                    break;
                } else if (randomNumber < userNumber) {
                    attemptsLeft--;
                    System.out.println("Загаданое число меньше, чем вы предполагаете."
                            + "\nОсталось " + attemptsLeft + " попыток!");
                } else {
                    attemptsLeft--;
                    System.out.println("Загаданое число больше вашего предположения."
                            + "\nОсталось  " + attemptsLeft + " попыток!");
                }
                if (attemptsLeft == 0) {
                    System.out.println("Вы не отгадали за 3 попытки. Загаданое число было "
                                       + randomNumber);
                }
            }
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
            if (scanner.nextInt() == 1) {
                gameWithRandom();
            } else {
                return;
            }
        }
    }

    //0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89
    public void fib(final int n) {
        int startInt = 0;
        int secondInt = 1;
        while (secondInt < n) {
            int temp = secondInt + startInt;
            startInt = secondInt;
            System.out.println(secondInt);
            secondInt = temp;
        }
    }
 }
