package model;

import java.util.ArrayList;

public class ListManagement {

    ArrayList<Task> listTaks;
    Task tasks;

    public void newTask(String nameTask) {
        listTaks.add(new Task(false, nameTask));
    }

    public void completedTask(int number) {
        listTaks.get(number).setCompleted(true);
    }

    public void viewTask() {

    }

    public void deleteTask() {

    }

    public void viewTaskIncomplete() {

    }
}
