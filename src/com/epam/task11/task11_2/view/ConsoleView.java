package com.epam.task11.task11_2.view;

import java.util.List;

public class ConsoleView implements View {

    @Override
    public <String>void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public <T> void showErrorMessage(T message) {
        System.err.println(message);
    }

    @Override
    public <E> void showArray(E[] array) {
        for (E element : array) {
            System.out.println(element);
        }
    }

    @Override
    public <E> void showList(List<E> list) {
        for (E element : list) {
            System.out.println(element);
        }
    }
}