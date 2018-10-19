package com.epam.task1.task1_2.controller;

import com.epam.task1.task1_2.model.Model;
import com.epam.task1.task1_2.view.View;

import java.util.Scanner;

public class Controller {
    private Model model = new Model();
    private View view = new View();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        view.print(model.searchPerfectNumbers(enterNumber()));
    }

    private int enterNumber() {
        int border;
        while (true) {
            view.printMessage(view.ENTER_BORDER);
            if (scanner.hasNextInt() && (border = scanner.nextInt()) > 0) {
                return border;
            } else {
                view.printMessage(view.WRONG_INPUT);
                scanner.next();
            }
        }
    }
}
