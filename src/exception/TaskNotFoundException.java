package exception;

public class TaskNotFoundException extends Exception {

    /**
     * Constructor method
     * @param message
     */
    public TaskNotFoundException(String message) {
        super(message);
    }
}
