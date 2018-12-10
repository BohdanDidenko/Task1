package com.epam.task11.task11_2.view;

import java.util.List;

public interface View {
    <T> void showMessage(T message);
    <T> void showErrorMessage(T message);
    <E> void showArray(E[] array);
    <E> void showList(List<E> list);
}
