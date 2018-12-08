package com.epam.task10.dao;

import com.epam.task10.model.entity.Shape;
import java.io.IOException;

public interface Dao {
    String getPath();
    void setPath(String path);
    Shape[] loadShapes();
    void saveShapes(Shape[] shape)  throws IOException;
}
