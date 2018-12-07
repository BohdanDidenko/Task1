package com.epam.task10.service;

import com.epam.task10.model.entity.Shape;

import java.io.IOException;

public interface Service {
    Shape[] getShapes();
    void setShapes(Shape[] shapes);
    String calculateTotalArea();
    <T>String calculateTotalArea(Class<T> type);
    void sortByIncreasingAreaOfFigures();
    void sortByColorOfFigures();
    void saveShapes() throws IOException;
    void loadShapes() throws IOException, ClassNotFoundException;
}
