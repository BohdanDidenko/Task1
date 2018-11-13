package com.epam.project2.service;

import com.epam.project2.model.Word;

public interface Service {
    Word[] getWordsFromFile();
    Word[] readAllWordInFile(String path) throws Exception;
    void sortTextWordsByAscendingVowelCount();
}
