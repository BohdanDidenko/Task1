package com.epam.task9;

import com.epam.task9.controller.LoadController;

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
