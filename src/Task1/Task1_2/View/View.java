package Task1.Task1_2.View;

import Task1.Task1_2.Model.Model;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
    private Scanner scanner = new Scanner(System.in);
    private int border;

    private static final String WRONG_INPUT = "Wrong input! Repeat please!";
    private static final String ENTER_BORDER = "Please enter a border";

    public void run(Model model) {
        enterNumber();
        print(model.searchPerfectNumbers(border));
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    private void enterNumber() {
        while (true) {
            printMessage(ENTER_BORDER);
            if (scanner.hasNextInt() && (border = scanner.nextInt()) > 0) {
                break;
            } else {
                printMessage(WRONG_INPUT);
                scanner.next();
                continue;
            }
        }
    }

    private void print (ArrayList<Integer> perfectNumbersList){
        for (int i: perfectNumbersList){
            System.out.println(i);
        }
    }
}
