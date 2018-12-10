package com.epam.task11.task11_2.dao;

import com.epam.task11.task11_2.model.entity.Shape;

import java.io.IOException;
import java.util.List;

public interface Dao {
    String getPath();
    void setPath(String path);
    List<Shape> loadShapes();
    void saveShapes(List<Shape> shapes)  throws IOException;
    void close();
}
