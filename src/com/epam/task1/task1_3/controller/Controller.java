package com.epam.task1.task1_3.controller;

import com.epam.task1.task1_3.model.Model;
import com.epam.task1.task1_3.view.View;

import java.util.Scanner;

public class Controller {
    private Model model = new Model();
    private View view = new View();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        view.printPyramid(model.buildPyramid(enterHeight()));
    }

    private int enterHeight() {
        int height;
        while (true) {
            view.printMessage(view.ENTER_HEIGHT_PYRAMID);
            if (scanner.hasNextInt() && (height = scanner.nextInt()) > 0 && height < 10) {
                return height;
            } else {
                view.printMessage(view.WRONG_INPUT);
                scanner.next();
            }
        }
    }
}

