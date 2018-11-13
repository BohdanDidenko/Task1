package com.epam.project2.view;

import java.util.List;

public interface View {
    void showMenu();
    <T>T getRequestFromUser();
    <T>void showMessage(T message);
    <E>void showList(List<E> list);
    <E>void showList(List<E> list, int count);
    <E> void showArray(E[] array);
}
