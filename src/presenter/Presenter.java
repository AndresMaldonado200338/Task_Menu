package presenter;

import exception.InvalidInputException;
import exception.OptionNotFoundException;
import exception.TaskAlreadyExistsException;
import exception.TaskNotFoundException;
import model.*;
import view.*;

public class Presenter {
    private ListManagement listManagement;
    private View view;

    /**
     * Constructor method
     */
    public Presenter() {
        listManagement = new ListManagement();
        view = new View();
        init();
    }

    /**
     * Method to initialize the program
     */
    public void init() {
        short option = 0;
        view.showMessage(Constants.MESSAGE_WELCOME);
        do {
            try {
                String input = view.readString(Constants.MENU);
                if (!input.matches("\\d+")) {
                    throw new InvalidInputException(Constants.MESSAGE_OPTION_ERROR + input);
                }
                option = Short.parseShort(input);
                switch (option) {
                    case 1:
                        createTask();
                        break;
                    case 2:
                        completedTask();
                        break;
                    case 3:
                        listTask();
                        break;
                    case 4:
                        deleteTask();
                        break;
                    case 5:
                        countTaskIncomplete();
                        break;
                    case 6:
                        view.showMessage("Bye");
                        System.exit(0);
                        break;
                    default:
                        throw new OptionNotFoundException(Constants.MESSAGE_OPTION_ERROR + option);
                }
            } catch (InvalidInputException e) {
                view.showMessage("Error: " + e.getMessage());
            } catch (OptionNotFoundException e) {
                view.showMessage("Error: " + e.getMessage());
            }
        } while (option != 6);
    }

    /**
     * Method to create a new task
     * 
     * @throws TaskAlreadyExistsException
     */
    public void createTask() {
        String nameTask = view.readString(Constants.MESSAGE_TASK);
        try {
            listManagement.newTask(nameTask);
            view.showMessage("Tarea creada con éxito.");
        } catch (TaskAlreadyExistsException e) {
            view.showMessage(Constants.MESSAGE_ERROR + e.getMessage());
        }
    }

    /**
     * Method to complete a task
     */
    public void completedTask() {
        String nameTask = view.readString(Constants.MESSAGE_TAST_TO_COMPLETE);
        try {
            listManagement.completedTask(nameTask);
            view.showMessage(Constants.MESSAGE_TASK_COMPLETED);
        } catch (TaskNotFoundException e) {
            view.showMessage(Constants.MESSAGE_ERROR + e.getMessage());
        }
    }

    /**
     * Method to view all tasks
     */
    public void listTask() {
        view.showMessage(listManagement.viewTask().toString());
    }

    /**
     * Method to delete a task
     */
    public void deleteTask() {
        String nameTask = view.readString(Constants.MESSAGE_TASK_TO_DELETE);
        try {
            listManagement.deleteTask(nameTask);
            view.showMessage(Constants.MESSAGE_TASK_DELETED);
        } catch (TaskNotFoundException e) {
            view.showMessage(Constants.MESSAGE_ERROR + e.getMessage());
        }
    }

    /**
     * Method to count task incomplete
     */
    public void countTaskIncomplete() {
        view.showMessage(listManagement.viewTaskIncomplete().toString());
    }

    public static void main(String[] args) {
        new Presenter();
    }
}