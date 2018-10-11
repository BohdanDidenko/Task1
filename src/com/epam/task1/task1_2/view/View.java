package com.epam.task1.task1_2.view;

import com.epam.task1.task1_2.model.Model;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
    public static final String WRONG_INPUT = "Wrong input! Repeat please!";
    public static final String ENTER_BORDER = "Please enter a border";

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void print (ArrayList<Integer> perfectNumbersList){
        for (int i: perfectNumbersList){
            System.out.println(i);
        }
    }
}
