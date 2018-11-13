package com.epam.project1.dao;

import com.epam.project1.model.warrior.Knight;

import java.io.*;

public class KnightDao implements Dao {
    private String path = "src\\com\\epam\\project1\\resource\\shapesArray.ser";

    @Override
    public Knight loadKnight() throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path))) {
            return (Knight) inputStream.readObject();
        }
    }

    @Override
    public void saveKnight(Knight knight) throws IOException{
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(path))) {
            outputStream.writeObject(knight);
        }
    }
}
