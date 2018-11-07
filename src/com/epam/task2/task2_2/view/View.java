package com.epam.task2.task2_2.view;

public interface View {
    void showMenu();
    <T>T getRequestFromUser();
    <T>void showMessage(T message);
    <E>void showArray(E[] array);
}
