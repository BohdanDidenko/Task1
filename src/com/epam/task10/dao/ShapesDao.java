package com.epam.task10.dao;

import com.epam.task10.model.entity.Shape;
import java.io.*;

public class ShapesDao implements Dao {
    private String path = "src\\com\\epam\\task10\\resource\\shapesArray.ser";

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public Shape[] loadShapes() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path))) {
            return (Shape[]) inputStream.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return new Shape[0];
    }

    @Override
    public void saveShapes(Shape[] shape) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(path))) {
            outputStream.writeObject(shape);
        }
    }
}
