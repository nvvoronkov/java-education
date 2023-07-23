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

    public void printMenu() {
        Scanner scanner = new Scanner(System.in);
        int attemptsLeft = 3;
        Random random = new Random();
        int randomNumber = random.nextInt(10);
        boolean attempt = false;

        while (attemptsLeft > 0 && !attempt) {
            System.out.println("Введите число от 0 до 9");
            int userNumber = scanner.nextInt();
            if (userNumber == randomNumber) {
                System.out.println("Вы угадали!");
                attempt = true;
            } else if (randomNumber < userNumber) {
                attemptsLeft--;
                System.out.println("Загаданое число меньше, чем вы предполагаете." +
                        "\nОсталось " + attemptsLeft + " попыток!");
            } else {
                attemptsLeft--;
                System.out.println("Загаданое число больше вашего предположения." +
                        "\nОсталось  " + attemptsLeft + " попыток!");
            }
        }
        if (!attempt) {
            System.out.println("Вы не отгадали за 3 попытки. Загаданое число было " + randomNumber);
        }
    }

    //0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89
    public void fib(int n) {
        int startInt = 0;
        int secondInt = 1;
        while(secondInt < n) {
            int temp = secondInt + startInt;
            startInt = secondInt;
            System.out.println(secondInt);
            secondInt = temp;
        }
    }
 }
