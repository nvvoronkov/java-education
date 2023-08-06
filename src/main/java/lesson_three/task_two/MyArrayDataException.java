package lesson_three.task_two;

public class MyArrayDataException extends RuntimeException {

    public MyArrayDataException(String message) {
        super(message);
    }

    public MyArrayDataException(String message, Throwable cause) {
        super(message, cause);
    }

}

