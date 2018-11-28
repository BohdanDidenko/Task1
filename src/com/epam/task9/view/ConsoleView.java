package com.epam.task9.view;

import java.util.Scanner;

/**
 * Класс ConsoleView отвечает за отображение данных модели пользователю,
 * реагируя на изменения модели
 */
public class ConsoleView implements View, ConsoleMessage {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public Scanner getRequestFromUser() {
        return scanner;
    }

    @Override
    public void showMenu() {
        showMessage(ConsoleMessage.MAIN_MENU);
    }

    @Override
    public <String>void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public <E> void showArray(E[] array) {
        for (E element : array) {
            System.out.println(element);
        }
    }
}