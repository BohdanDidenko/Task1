package com.epam.task5.task5_3.dao;

import com.epam.task5.task5_3.model.Vocabulary;
import java.io.*;

public class VocabularyDao implements Dao {
    private String path = "src\\com\\epam\\task5\\task5_3\\resource\\Vocabulary.ser";

    @Override
    public Vocabulary loadVocabulary()  throws IOException, ClassNotFoundException{
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path))) {
            return (Vocabulary) inputStream.readObject();
        }
    }

    @Override
    public void saveVocabulary(Vocabulary vocabulary)  throws IOException{
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(path))) {
            outputStream.writeObject(vocabulary);
        }
    }
}
