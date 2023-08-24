package view;

import java.util.Scanner;

public class View {

    private Scanner input;

    /**
     * Constructor method
     */
    public View() {
        input = new Scanner(System.in);
    }

    /**
     * Method to show a message
     * @param message
     */
    public void showMessage(String message) {
        System.out.println("\n" + message);
    }

    /**
     * Method to read a short
     */
    public short readShort(String message) {
        this.showMessage(message);
        return input.nextShort();
    }

    /**
     * Method to read a string
     * @param message
     * @return
     */
    public String readString(String message) {
        this.showMessage(message);
        return input.next();
    }
}