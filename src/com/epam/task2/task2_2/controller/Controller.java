package com.epam.task2.task2_2.controller;

import com.epam.task2.task2_2.data.DataSource;
import com.epam.task2.task2_2.model.Shapes;
import com.epam.task2.task2_2.model.entity.Circle;
import com.epam.task2.task2_2.model.entity.Rectangle;
import com.epam.task2.task2_2.model.entity.Triangle;
import com.epam.task2.task2_2.view.ShapesView;
import java.util.Scanner;

/**
 * Класс Controller интерпретирует действия пользователя,
 * оповещая модель о необходимости изменений
 */

public class Controller {
    /**
     * Поле предоставляющие доступ к данным и методам работы с ними
     */
    private Shapes model = new Shapes();

    /**
     * Поле предоставляющие доступ к данным отображаемым пользователю
     */
    private ShapesView view = new ShapesView();

    /**
     * Главный метод класса Controller инициализирующий поле shapes[] принадлежащие модели,
     * и исполняющий метод selectAction, который отвечает за взаимодействие с пользователем
     */
    public void run(){
        model.setShapes(DataSource.getShapes());
        selectAction();
    }

    /**
     * Метод отвечает за взаимодействие с пользователем и предлагает ему
     * выполнить 1 из 6 операций, или закончить работу программы
     */
    private void selectAction() {
        int choice;

        while (true) {
            choice = inputNumber(view.getScannerForChoice());
            switch (choice) {
                case 1: {
                    view.printMessage(String.valueOf
                            (model.calculateTotalArea()));
                    break;
                }
                case 2: {
                    view.printMessage(model.calculateTotalArea(new Circle()));
                    break;
                }
                case 3: {
                    view.printMessage(model.calculateTotalArea(new Triangle()));
                    break;
                }
                case 4: {
                    view.printMessage(model.calculateTotalArea(new Rectangle()));
                    break;
                }
                case 5: {
                    model.sort(model.getShapeAreaComparator());
                    view.printShapes(model.getShapes());
                    break;
                }
                case 6: {
                    model.sort(model.getShapeColorComparator());
                    view.printShapes(model.getShapes());
                    break;
                }
                case 0: {
                    return;
                }
                default: {
                    view.printMessage(view.WRONG_INPUT);
                    view.getScannerForChoice().next();
                }
            }
        }
    }

    /**
     * Метод запрашивает у пользователя ввод положительного целого числа
     * от 1 до 6 - для исполнения выбранной операции
     * или 0 - для выхода из программы
     *
     * @param scannerForChoice - считывает данные введенные пользователем
     */
    private int inputNumber(Scanner scannerForChoice){
        while (true) {
            view.printMessage(view.SELECT_AN_ACTION);

            if (scannerForChoice.hasNextInt())
                return scannerForChoice.nextInt();
            else {
                view.printMessage(view.WRONG_INPUT);
                scannerForChoice.next();
            }
        }
    }
}
