package com.epam.task2.task2_2.dao;

import com.epam.task2.task2_2.model.entity.Shape;
import java.io.IOException;

public interface Dao {
    Shape[] loadShapes()  throws IOException, ClassNotFoundException;
    void saveShapes(Shape[] shape)  throws IOException;
}
