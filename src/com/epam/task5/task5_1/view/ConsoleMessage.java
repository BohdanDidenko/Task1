package com.epam.task5.task5_1.view;

public interface ConsoleMessage {
    String MAIN_MENU = "Select an action: " + "\n" +
            "1 - Show current list of entries in curator's journal" + "\n" +
            "2 - Add new student's record to curator's journal" + "\n" +
            "3 - Exit";

    String ENTER_STUDENT_NAME = "Please enter a student's name";
    String ENTER_STUDENT_SECOND_NAME = "Please enter a student's second name.";
    String ENTER_DATE_OF_BIRTH = "Please enter a student's date of birth.";
    String ENTER_PHONE_NUMBER = "Please enter a student's phone number.";
    String ENTER_HOME_ADDRESS = "Please enter a student's home address.";

    String WRONG_INPUT = "Wrong input! Repeat please!";
    String NO_RESULT = "No results were found for your search";
}
