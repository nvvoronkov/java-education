package lesson_three.task_two;

public class Task {
    public int inputArray(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;

        if (arr.length != 4) {
            throw new MyArraySizeException("The size of the array must be 4x4");
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException("The size of the array must be 4x4");
            }
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException ex) {
                    throw new MyArrayDataException("Invalid data in a cell [" + i + "][" + j + "]!", ex);
                }
            }
        }
        return sum;
    }
}
