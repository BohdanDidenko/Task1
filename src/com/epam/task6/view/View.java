package com.epam.task6.view;

public interface View {
    void showMenu();
    <T>T getRequestFromUser();
    <T>void showMessage(T message);
    <E>void showArray(E[] array);
}
