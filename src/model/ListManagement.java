package model;

import java.util.ArrayList;
import exception.*;
import view.Constants;

public class ListManagement {

    ArrayList<Task> listTaks = new ArrayList<>();
    Task tasks;

    /**
     * Method to create a new task
     * 
     * @param nameTask
     * @throws TaskAlreadyExistsException
     */
    public void newTask(String nameTask) throws TaskAlreadyExistsException {
        if (validationNameTask(nameTask)) {
            throw new TaskAlreadyExistsException(Constants.MESSAGE_TASK_ALREADY_EXISTS + nameTask);
        }
        listTaks.add(new Task(false, nameTask));
    }

    /**
     * Method to view all tasks
     * 
     * @return
     * @throws TaskNotFoundException
     */
    public void completedTask(String nameTask) throws TaskNotFoundException {
        if (!validationNameTask(nameTask)) {
            throw new TaskNotFoundException(Constants.MESSAGE_TASK_NOT_FOUND + nameTask);
        }
        searchObjectForNameTask(nameTask).setCompleted(true);
    }

    /**
     * Method to view all tasks with status
     * 
     * @return
     */
    public StringBuilder viewTask() {
        StringBuilder auxStringBuilder = new StringBuilder("");
        for (int i = 0; i < listTaks.size(); i++) {
            auxStringBuilder.append(i + 1 + "-");
            auxStringBuilder.append(listTaks.get(i).getNameTask() + Constants.MESSAGE_STATUS + listTaks.get(i).estatus() + "\n");
        }
        return auxStringBuilder;
    }

    /**
     * Method to delete a task
     * 
     * @param nameTask
     * @throws TaskNotFoundException
     */
    public void deleteTask(String nameTask) throws TaskNotFoundException {
        int position = searchNumberForNameTask(nameTask);
        if (position < 0) {
            throw new TaskNotFoundException(Constants.MESSAGE_TASK_NOT_FOUND + nameTask);
        }
        listTaks.remove(position);
    }

    /**
     * Method to view all tasks incomplete
     * 
     * @return
     */
    public StringBuilder viewTaskIncomplete() {
        StringBuilder auxStringBuilder = new StringBuilder("");
        int counter = 0;
        for (int i = 0; i < listTaks.size(); i++) {
            if (!listTaks.get(i).isCompleted()) {
                auxStringBuilder.append(i + 1 + "-");
                auxStringBuilder.append(listTaks.get(i).getNameTask() + "\n");
                counter++;
            }
        }
        auxStringBuilder.append(Constants.MESSAGE_TASK_INCOMPLETE + counter);
        return auxStringBuilder;
    }

    /**
     * Method to validate the name of the task
     * 
     * @param nameTask
     * @return
     */
    public boolean validationNameTask(String nameTask) {
        boolean auxBoolean = false;
        for (int j = 0; j < listTaks.size(); j++) {
            if (nameTask.equals(listTaks.get(j).getNameTask())) {
                auxBoolean = true;
            }
        }
        return auxBoolean;
    }

    /**
     * Method to search the object for the name of the task
     * 
     * @param nameTask
     * @return
     */
    public Task searchObjectForNameTask(String nameTask) {
        for (int j = 0; j < listTaks.size(); j++) {
            if (nameTask.equals(listTaks.get(j).getNameTask())) {
                return listTaks.get(j);
            }
        }
        return null;
    }

    /**
     * Method to search the number for the name of the task
     * 
     * @param nameTask
     * @return
     */
    public int searchNumberForNameTask(String nameTask) {
        if (validationNameTask(nameTask)) {
            for (int j = 0; j < listTaks.size(); j++) {
                if (nameTask.equals(listTaks.get(j).getNameTask())) {
                    return j;
                }
            }
        }
        return -1;
    }
}