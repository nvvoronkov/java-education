package lesson_three.task_two;

import java.io.File;

public class Main {
    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
        Task task = new Task();
        String[][] array = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"5", "6", "7", "8"},
                {"5", "6", "7", "8"}
        };
        System.out.println(task.inputArray(array));

        File file = null;
        try {
            file = FileUtil.openFile("path.to.file");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        boolean delete = file.delete();

        System.out.println(delete);

        System.out.println("LAST STRING");
    }


}
