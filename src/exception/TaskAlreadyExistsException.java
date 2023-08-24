package exception;

public class TaskAlreadyExistsException extends Exception {

    /**
     * Constructor method
     * @param message
     */
    public TaskAlreadyExistsException(String message) {
        super(message);
    }
}
