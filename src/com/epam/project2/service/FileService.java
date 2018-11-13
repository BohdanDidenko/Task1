package com.epam.project2.service;

import com.epam.project2.model.EnglishAlphabetSymbol;
import com.epam.project2.model.Word;
import com.epam.project2.service.reader.PdfReader;
import com.epam.project2.service.reader.TxtReader;
import java.io.IOException;
import java.util.Arrays;

public class FileService implements Service{
    private PdfReader pdfReader = new PdfReader();
    private TxtReader txtReader = new TxtReader();
    private Word[] wordsFromFile;

    @Override
    public Word[] getWordsFromFile() {
        return wordsFromFile;
    }

    @Override
    public Word[] readAllWordInFile(String path) throws Exception {
        String[] textFromFile;
        if(path.endsWith("pdf")){
            textFromFile = pdfReader.readPdfDocument(path).replaceAll("\\p{Punct}", "").split(" ");
        } else if(path.endsWith("txt")){
            textFromFile = txtReader.readTxtDocument(path).replaceAll("\\p{Punct}", "").split(" ");
        } else {
            throw new IOException();
        }

        wordsFromFile = new Word[textFromFile.length];

        for (int i = 0; i < textFromFile.length; i++) {
            char[] chars = textFromFile[i].toCharArray();
            EnglishAlphabetSymbol[] alphabetSymbols = new EnglishAlphabetSymbol[chars.length];

            for (int j = 0; j < chars.length; j++) {
                alphabetSymbols[j] = new EnglishAlphabetSymbol(chars[j]);
            }
            wordsFromFile[i] = new Word(alphabetSymbols);
        }
        return wordsFromFile;
    }

    @Override
    public void sortTextWordsByAscendingVowelCount(){
        Arrays.sort(wordsFromFile, (o1, o2) -> {
            if (o1 == null) return 0;
            if (o2 == null) return 0;
            double coefficientOne = (double) (o1.getCountVowel())/((double)o1.getCountAllSumbols());
            double coefficientTwo = (double) (o2.getCountVowel())/((double)o2.getCountAllSumbols());
            if (coefficientOne > coefficientTwo) return 1;
            else if (coefficientOne < coefficientTwo) return -1;
            else return 0;
        });
    }
}
