package com.epam.task5.task5_3.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Vocabulary implements Serializable {
    private Map<String, String> vocabulary = new HashMap<>();

    public Map<String, String> getVocabulary() {
        return vocabulary;
    }

    public void setVocabulary(Map<String, String> vocabulary) {
        this.vocabulary = vocabulary;
    }
}
