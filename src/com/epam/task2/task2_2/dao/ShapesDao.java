package com.epam.task2.task2_2.dao;

import com.epam.task2.task2_2.model.entity.Shape;
import java.io.*;

public class ShapesDao implements Dao {
    private String path = "src\\com\\epam\\task2\\task2_2\\resource\\shapesArray.ser";

    @Override
    public Shape[] loadShapes() throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path))) {
            return (Shape[]) inputStream.readObject();
        }
    }

    @Override
    public void saveShapes(Shape[] shape) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(path))) {
            outputStream.writeObject(shape);
        }
    }
}
