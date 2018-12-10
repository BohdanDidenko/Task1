package com.epam.task11.task11_2.service;

import com.epam.task11.task11_2.exception.UnExistItemMenu;
import com.epam.task11.task11_2.model.entity.Shape;

import java.io.IOException;
import java.util.List;

public interface Service {
    List<Shape> getShapes();
    void setShapes(List<Shape> shapes);
    String calculateTotalArea();
    <T>String calculateTotalArea(Class<T> type);
    void sortByIncreasingAreaOfFigures();
    void sortByColorOfFigures();
    void changeLanguare(int choise) throws UnExistItemMenu;
    void saveShapes() throws IOException;
}
