package Task1.Task1_1.View;

import Task1.Task1_1.Model.Model;

import java.util.Scanner;

public class View {
    private Scanner scanner = new Scanner(System.in);
    private int number;

    private static final String WRONG_INPUT = "Wrong input! Repeat please!";
    private static final String ENTER_POSITIVE_NUMBER = "Please enter a positive number in decimal system";
    private static final String SELECT_NUMBERING_SYSTEM = "Select numbering system: 1 - binary, 2 - octal, 3 - hexadecimal";

    public void run(Model model) {
        enterNumber();
        selectNumberSystem(model);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    private void enterNumber() {
        while (true) {
            printMessage(ENTER_POSITIVE_NUMBER);
            if (scanner.hasNextInt() && (number = scanner.nextInt()) > 0) {
                break;
            } else {
                printMessage(WRONG_INPUT);
                scanner.next();
                continue;
            }
        }
    }

    private void selectNumberSystem(Model model) {
        while (true) {
            int choice;

            printMessage(SELECT_NUMBERING_SYSTEM);

            if (scanner.hasNextInt())
                choice = scanner.nextInt();
            else {
                printMessage(WRONG_INPUT);
                scanner.next();
                continue;
            }

            switch (choice) {
                case 1: {
                    printMessage(model.toBinary(number));
                    return;
                }
                case 2: {
                    printMessage(model.toOctal(number));
                    return;
                }
                case 3: {
                    printMessage(model.toHexadecimal(number));
                    return;
                }
                default: {
                    printMessage(WRONG_INPUT);
                    scanner.next();
                    continue;
                }
            }
        }
    }
}
