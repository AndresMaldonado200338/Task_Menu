package model;

public class Task {
    private boolean completed;
    private String nameTask;

    public Task(boolean completed, String nameTask) {
        this.completed = completed;
        this.nameTask = nameTask;
    }

    public boolean isCompleted(){
        return completed;
    }
    
    public String estatus() {
        String estatus;
        if (completed==false) {
            estatus = "Incompleta";
        }else{
            estatus = "Completa";
        }
        return estatus;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getNameTask() {
        return nameTask;
    }

    public void setNameTask(String nameTask) {
        this.nameTask = nameTask;
    }

}
