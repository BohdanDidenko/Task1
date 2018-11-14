package com.epam.task5.task5_3.service;

import com.epam.task5.task5_3.model.Vocabulary;

public class VocabularyService implements Service<Vocabulary, String> {

    public String translateSentence(Vocabulary vocabulary, String line){
        StringBuilder stringBuilder = new StringBuilder();
        String[] arrayWords = line.replaceAll("\\p{Punct}", "").split(" ");
        for (String s : arrayWords) {
            if(vocabulary.getVocabulary().containsKey(s)) {
                stringBuilder.append(vocabulary.getVocabulary().get(s));
            }
            else return null;
        }
        return stringBuilder.toString();
    }

    public void addNewWordToVocabulary(Vocabulary vocabulary, String wordInEnglish, String wordInRussian){
        vocabulary.getVocabulary().put(wordInEnglish, wordInRussian);
    }

    private void translateWord(){

    }
}
