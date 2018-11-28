package com.epam.task9.service;

import com.epam.task9.model.entity.Shape;

public interface Service {
    Shape[] getShapes();
    void setShapes(Shape[] shapes);
    String calculateTotalArea();
    <T>String calculateTotalArea(Class<T> type);
    void sortByIncreasingAreaOfFigures();
    void sortByColorOfFigures();
}
