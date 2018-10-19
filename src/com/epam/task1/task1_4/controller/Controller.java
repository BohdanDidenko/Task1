package com.epam.task1.task1_4.controller;

import com.epam.task1.task1_4.model.Model;
import com.epam.task1.task1_4.view.View;

import java.util.Scanner;

public class Controller {
    private Model model = new Model();
    private View view = new View();
    private Scanner scanner = new Scanner(System.in);


    public void run() {
        model.setSize(enterNumber(view.ENTER_HEIGHT_MATRIX));
        model.setMaxValue(enterNumber(view.ENTER_MAX_VALUE_FOR_MATRIX_FILLING));
        model.setMatrix(model.createMatrix(model.getSize(), model.getMaxValue()));
        view.printMatrix(model.getMatrix());
        selectAction(model);
    }

    private int enterNumber(String massage) {
        int number;

        while (true) {
            view.printMessage(massage);
            if (scanner.hasNextInt() && (number = scanner.nextInt()) >= 0) {
                return number;
            } else {
                view.printMessage(view.WRONG_INPUT);
                scanner.next();
            }
        }
    }

    private void selectAction(Model model) {
        while (true){
            int choice = enterNumber(view.SELECT_AN_ACTION);
            switch (choice) {
                case 1: {
                    model.rotateMatrixLeft(model.getMatrix());
                    view.printMatrix(model.getMatrix());
                    break;
                }
                case 2: {
                    model.rotateMatrixRight(model.getMatrix());
                    view.printMatrix(model.getMatrix());
                    break;
                }
                case 0: {
                    return;
                }
                default: {
                    view.printMessage(view.WRONG_INPUT);
                    scanner.next();
                }
            }
        }
    }
}
