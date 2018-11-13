package com.epam.project2.view;

public interface ConsoleMessage {
    String MAIN_MENU = "Select an action: " + "\n" +
            "1 - Select another file for read data" + "\n" +
            "2 - Sort words by ascending vowel count" + "\n" +
            "3 - Exit";

    String START = "This program works with files.";
    String FILE_NAME = "Please enter a file name.";
    String READING = "data is reading from file...";

    String EXCEPTION = "Upss...Something must have gone wrong! =(";
    String WRONG_INPUT = "Wrong input! Repeat please!";
    String NO_RESULT = "No results were found for your search";
}
