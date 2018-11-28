package com.epam.task9.view;

public interface View {
    void showMenu();
    <T>T getRequestFromUser();
    <T>void showMessage(T message);
    <E>void showArray(E[] array);
}
