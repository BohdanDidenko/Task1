package com.epam.task3.task3_2.view;

import java.util.List;
import java.util.Scanner;

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
    public <T>void showMessage(T message) {
        System.out.println(message);
    }

    @Override
    public <E> void showList(List<E> list) {
        for (E element : list) {
            System.out.println(element);
        }
    }
}
