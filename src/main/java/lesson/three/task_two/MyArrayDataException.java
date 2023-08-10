package lesson.three.task_two;

public class MyArrayDataException extends RuntimeException {

    public MyArrayDataException(final String message) {
        super(message);
    }

    public MyArrayDataException(final String message, Throwable cause) {
        super(message, cause);
    }

}

