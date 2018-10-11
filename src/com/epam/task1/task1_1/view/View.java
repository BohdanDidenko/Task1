package com.epam.task1.task1_1.view;

import com.epam.task1.task1_1.model.Model;

import java.util.Scanner;

public class View {
    public static final String WRONG_INPUT = "Wrong input! Repeat please!";
    public static final String ENTER_POSITIVE_NUMBER = "Please enter a positive number in decimal system";
    public static final String SELECT_NUMBERING_SYSTEM = "Select numbering system: 1 - binary, 2 - octal, 3 - hexadecimal";

    public void printMessage(String message) {
        System.out.println(message);
    }
}
