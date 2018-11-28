package com.epam.task9.dao;

import com.epam.task9.model.entity.Shape;
import java.io.IOException;

public interface Dao {
    String getPath();
    void setPath(String path);
    Shape[] loadShapes()  throws IOException, ClassNotFoundException;
    void saveShapes(Shape[] shape)  throws IOException;
}
