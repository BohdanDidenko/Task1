package com.epam.task3.task3_1.view;

import java.util.List;

public interface View {
    void showMenu();
    <T>T getRequestFromUser();
    <T>void showMessage(T message);
    <E>void showList(List<E> list);
}
