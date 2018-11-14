package com.epam.task5.task5_3.service;

public interface Service<T, S> {
    S translateSentence(T vocabulary, S line);
    void addNewWordToVocabulary(T vocabulary, S wordInEnglish, S wordInRussian);
}
