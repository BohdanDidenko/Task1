package com.epam.task2.task2_2.view;

import com.epam.task2.task2_2.model.entity.Shape;

import java.util.Scanner;

/**
 * Класс ShapesView отвечает за отображение данных модели пользователю,
 * реагируя на изменения модели
 */

public class ShapesView {

    /**
     * Поле принимающие данные введенные пользователем
     */
    private Scanner scannerForChoice = new Scanner(System.in);

    /**
     * Константа с перечнем допустимых действий для выбора пользователем
     */
    public static final String SELECT_AN_ACTION = "Select an action: " + "\n" +
            "1 - Calculate the total area of all figures, " + "\n" +
            "2 - Calculate the total area of all circles, " + "\n" +
            "3 - Calculate the total area of all triangles, " + "\n" +
            "4 - Calculate the total area of all rectangles, " + "\n" +
            "5 - Sort by increasing the area of figures, " + "\n" +
            "6 - Sort by color of figures, " + "\n" +
            "0 - exit";
    /**
     * Константа уведомляющая пользователя о некорректно введенных данных
     */
    public static final String WRONG_INPUT = "Wrong input! Repeat please!";

    public Scanner getScannerForChoice() {
        return scannerForChoice;
    }

    /**
     * Метод отображает в консоль пользователю массив полученных фигур
     *
     * @param shapes - массив фигур
     */
    public void printShapes(Shape[] shapes) {
        for (Shape shape : shapes) {
            shape.draw();
        }
    }

    /**
     * Метод отображает в консоль пользователю полученное сообщение
     *
     * @param message - полученное сообщение
     */
    public void printMessage(String message) {
        System.out.println(message);
    }
}
