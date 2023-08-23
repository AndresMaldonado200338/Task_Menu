package model;

import java.util.ArrayList;

public class ListManagement {

    ArrayList<Task> listTaks;
    Task tasks;

    public void newTask(String nameTask) {
        listTaks.add(new Task(false, nameTask));
    }

    public void completedTask(String nameTask) {
        if (validationNameTask(nameTask)) {
            searchObjectForNameTask(nameTask).setCompleted(true);
        }

    }

    public StringBuilder viewTask() {
        StringBuilder auxStringBuilder = new StringBuilder("");
        for (int i = 0; i < listTaks.size(); i++) {
            if (listTaks.get(i).isCompleted()) {
                auxStringBuilder.append(i + 1);
                auxStringBuilder.append(listTaks.get(i).getNameTask());
            }
        }
        return auxStringBuilder;
    }

    public void deleteTask(String nameTask) {
        int position = searchNumberForNameTask(nameTask);
        listTaks.remove(position);
    }

    public StringBuilder viewTaskIncomplete() {
        StringBuilder auxStringBuilder = new StringBuilder("");
        for (int i = 0; i < listTaks.size(); i++) {
            if (!listTaks.get(i).isCompleted()) {
                auxStringBuilder.append(i + 1);
                auxStringBuilder.append(listTaks.get(i).getNameTask());
            }
        }
        return auxStringBuilder;
    }

    public boolean validationNameTask(String nameTask) {
        boolean auxBoolean = false;
        for (int j = 0; j < listTaks.size(); j++) {
            if (nameTask.equals(listTaks.get(j).getNameTask())) {
                auxBoolean = true;
            }
        }
        return auxBoolean;
    }

    public Task searchObjectForNameTask(String nameTask) {
        for (int j = 0; j < listTaks.size(); j++) {
            if (nameTask.equals(listTaks.get(j).getNameTask())) {
                return listTaks.get(j);
            }
        }
        return null;
    }

    public int searchNumberForNameTask(String nameTask) {
        for (int j = 0; j < listTaks.size(); j++) {
            if (nameTask.equals(listTaks.get(j).getNameTask())) {
                return j;
            }
        }
        return 0;
    }

}
