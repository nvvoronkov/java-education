package lesson_three.task_two;

public class Main {
    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
        Task task = new Task();
        String[][] array = {{"1","2","3","4"}, {"5","6","7","8"}};
        System.out.println(task.inputArray(array));
    }
}
