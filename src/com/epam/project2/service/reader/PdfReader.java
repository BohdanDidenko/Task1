package com.epam.project2.service.reader;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import java.io.File;
import java.io.IOException;

public class PdfReader {
    public String readPdfDocument(String path) throws IOException {
        String textInFile = "";
        try (PDDocument document = PDDocument.load(new File(path))) {
            if (!document.isEncrypted()) {
                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                stripper.setSortByPosition(true);
                PDFTextStripper tStripper = new PDFTextStripper();
                textInFile = tStripper.getText(document);
            }
        }
        return textInFile;
    }
}