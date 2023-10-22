package lesson.files.task_two;

public class Task {
    public int inputArray(final String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        final int arrayLength = 4;

        if (arr.length != arrayLength) {
            throw new MyArraySizeException("The size of the array must be 4x4");
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != arrayLength) {
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
