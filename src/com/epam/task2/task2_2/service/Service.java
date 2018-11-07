package com.epam.task2.task2_2.service;

import com.epam.task2.task2_2.model.entity.Shape;

public interface Service {
    Shape[] getShapes();
    void setShapes(Shape[] shapes);
    String calculateTotalArea();
    <T>String calculateTotalArea(Class<T> type);
    void sortByIncreasingAreaOfFigures();
    void sortByColorOfFigures();
}
