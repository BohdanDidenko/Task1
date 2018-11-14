package com.epam.task5.task5_3.dao;

import com.epam.task5.task5_3.model.Vocabulary;
import java.io.IOException;

public interface Dao {
    Vocabulary loadVocabulary()  throws IOException, ClassNotFoundException;
    void saveVocabulary(Vocabulary vocabulary)  throws IOException;
}
