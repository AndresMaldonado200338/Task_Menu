package presenter;

import model.*;
import view.*;

public class Presenter {
    private ListManagement listManagement;
    private View view;

    public Presenter() {
        listManagement = new ListManagement();
        view = new View();
        init();
    }

    public void init() {
        short option = 0;
        do {
            option = view.readShort(Constants.MENU);
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
                    view.showMessage("Option invalid");
                    break;
            }
        } while (option != 6);
    }

    public void createTask() {
        String nameTask = view.readString("Ingrese el nombre de la tarea");
        listManagement.newTask(nameTask);
    }

    public void completedTask() {
        String nameTask = view.readString("Ingrese el nombre de la tarea");
        listManagement.completedTask(nameTask);
    }

    public void listTask() {
        view.showMessage(listManagement.viewTask().toString());
    }

    public void deleteTask() {
        String nameTask = view.readString("Ingrese el nombre de la tarea");
        listManagement.deleteTask(nameTask);
    }

    public void countTaskIncomplete() {
        view.showMessage(listManagement.viewTaskIncomplete().toString());
    }

    public static void main(String[] args) {
        new Presenter();
    }
}
