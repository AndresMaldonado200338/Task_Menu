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

    public void init(){
        short option = 0;
        do {
            option = view.readShort(Constants.MENU);
            switch (option) {
                case 1:
                    listManagement.newTask(view.readString("Name Task: "));
                    break;
                case 2:
                    listManagement.completedTask(view.readShort("Number Task: "));
                    break;
                case 3:
                    listManagement.viewTask();
                    break;
                case 4:
                    listManagement.deleteTask();
                    break;
                case 5:
                    listManagement.viewTaskIncomplete();
                    break;
                case 6:
                    view.showMessage("Bye");
                    break;
                default:
                    view.showMessage("Option invalid");
                    break;
            }
        } while (option != 6);
    }
}
