package view;

import java.util.Scanner;

public class View {

    private Scanner input;

    public View() {
        input = new Scanner(System.in);
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public short readShort(String message) {
        this.showMessage(message);
        return input.nextShort();
    }

    public String readString(String message) {
        this.showMessage(message);
        return input.next();
    }
}