package lesson.three.task_two;

public class MyArrayDataException extends RuntimeException {

    public MyArrayDataException(final String message) {
        super(message);
    }

    public MyArrayDataException(final String message, final Throwable cause) {
        super(message, cause);
    }

}

