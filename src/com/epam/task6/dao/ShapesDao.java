package com.epam.task6.dao;

import com.epam.task6.dao.Dao;
import com.epam.task6.model.entity.Shape;
import java.io.*;

public class ShapesDao implements Dao {
    private String path = "src\\com\\epam\\task6\\resource\\shapesArray.ser";

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public void setPath(String path) {
        this.path = path;
    }

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
