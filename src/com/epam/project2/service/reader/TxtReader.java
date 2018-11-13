package com.epam.project2.service.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TxtReader {
    public String readTxtDocument(String path) throws IOException {
        StringBuilder textInFile = new StringBuilder();
        try (BufferedReader document = new BufferedReader(new FileReader(path))) {
            while (document.ready()) {
                textInFile.append(document.readLine());
            }
        }
        return textInFile.toString();
    }
}