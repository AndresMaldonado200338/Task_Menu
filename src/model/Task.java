package model;

public class Task {
    private boolean completed;
    private String nameTask;

    /**
     * Constructor method
     * @param completed
     * @param nameTask
     */
    public Task(boolean completed, String nameTask) {
        this.completed = completed;
        this.nameTask = nameTask;
    }

    /**
     * Method to know if the task is completed
     * @return completed
     */
    public boolean isCompleted() {
        return completed;
    }

    /**
     * Method to know the status of the task
     * @return estatus
     */
    public String estatus() {
        String estatus;
        if (completed == false) {
            estatus = "Incompleta";
        } else {
            estatus = "Completa";
        }
        return estatus;
    }

    /**
     * Method to change the status of the task
     * @param completed
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    /**
     * Method to know the name of the task
     * @return nameTask
     */
    public String getNameTask() {
        return nameTask;
    }

    /**
     * Method to change the name of the task
     * @param nameTask
     */
    public void setNameTask(String nameTask) {
        this.nameTask = nameTask;
    }

}