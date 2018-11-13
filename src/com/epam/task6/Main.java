package com.epam.task6;

import com.epam.task6.controller.LoadController;

/**
 * Главные класс отвечающий за начало выполнения программы
 */
public class Main {

    /**
     * Начало выполнения программы
     */
    public static void main(String[] args) {
        new LoadController().run();
    }
}
