package com.epam.task5.task5_1.view;

import java.util.List;

public interface View {
    void showMenu();
    <T>T getRequestFromUser();
    <T>void showMessage(T message);
    <E>void showList(List<E> list);
}
