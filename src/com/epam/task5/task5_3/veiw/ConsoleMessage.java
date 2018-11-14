package com.epam.task5.task5_3.veiw;

public interface ConsoleMessage {
    String MAIN_MENU = "Select an action: " + "\n" +
            "1 - Translate sentence" + "\n" +
            "2 - Add a new word to the vocabulary" + "\n" +
            "3 - Exit";

    String SENTENCE_IN_ENGLISH = "Please enter a sentence in english";
    String WORD_IN_ENGLISH = "Please enter a word in english";
    String WORD_IN_RUSSIAN = "Please enter a word in russian";

    String WRONG_INPUT = "Wrong input! Repeat please!";
    String NO_RESULT = "No results were found for your search";
    String EXCEPTION = "Upss...Something must have gone wrong! =(";
}
