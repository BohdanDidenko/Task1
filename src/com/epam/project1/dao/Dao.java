package com.epam.project1.dao;

import com.epam.project1.model.warrior.Knight;

import java.io.IOException;

public interface Dao {
    Knight loadKnight()  throws IOException, ClassNotFoundException;
    void saveKnight(Knight knight)  throws IOException;
}
