package com.epam.task1.task1_1.controller;

import com.epam.task1.task1_1.model.Model;
import com.epam.task1.task1_1.view.View;

import java.util.Scanner;

public class Controller {
    private Model model = new Model();
    private View view = new View();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        selectNumberSystem(enterNumber(view.ENTER_POSITIVE_NUMBER));
    }

    private int enterNumber(String massage) {
        int number;
        while (true) {
            view.printMessage(massage);
            if (scanner.hasNextInt() && (number = scanner.nextInt()) > 0) {
                return number;
            } else {
                view.printMessage(view.WRONG_INPUT);
                scanner.next();
                continue;
            }
        }
    }

    private void selectNumberSystem(int number) {
        int choice;

        while (true) {
            choice = enterNumber(view.SELECT_NUMBERING_SYSTEM);

            switch (choice) {
                case 1: {
                    model.toBinary(number);
                    view.printMessage(model.result.reverse().toString());
                    return;
                }
                case 2: {
                    model.toOctal(number);
                    view.printMessage(model.result.reverse().toString());
                    return;
                }
                case 3: {
                    model.toHexadecimal(number);
                    view.printMessage(model.result.reverse().toString());
                    return;
                }
                default: {
                    view.printMessage(view.WRONG_INPUT);
                    scanner.next();
                    continue;
                }
            }
        }
    }
}
