package model;

import java.util.ArrayList;

public class ListManagement {

    ArrayList<Task> listTaks = new ArrayList<>();
    Task tasks;

    /**
     * Method to create a new task
     * 
     * @param nameTask
     */
    public void newTask(String nameTask) {
        listTaks.add(new Task(false, nameTask));
    }

    /**
     * Method to view all tasks
     * 
     * @return
     */
    public void completedTask(String nameTask) {
        if (validationNameTask(nameTask)) {
            searchObjectForNameTask(nameTask).setCompleted(true);
        }

    }

    /**
     * Method to view all tasks
     * 
     * @return
     */
    public StringBuilder viewTask() {
        StringBuilder auxStringBuilder = new StringBuilder("");
        for (int i = 0; i < listTaks.size(); i++) {
            auxStringBuilder.append(i + 1);
            auxStringBuilder.append(listTaks.get(i).getNameTask());
        }
        return auxStringBuilder;
    }

    /**
     * method to delete all tasks
     * 
     * @param nameTask
     */
    public void deleteTask(String nameTask) {
        int position = searchNumberForNameTask(nameTask);
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
                auxStringBuilder.append(i + 1);
                auxStringBuilder.append(listTaks.get(i).getNameTask());
                counter++;
            }
        }
        auxStringBuilder.append("Tareas pendientes: " + counter);
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
        for (int j = 0; j < listTaks.size(); j++) {
            if (nameTask.equals(listTaks.get(j).getNameTask())) {
                return j;
            }
        }
        return 0;
    }

}
