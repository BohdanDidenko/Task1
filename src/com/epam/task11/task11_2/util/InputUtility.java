package com.epam.task11.task11_2.util;

import com.epam.task11.task11_2.util.ResourceManager;
import com.epam.task11.task11_2.view.View;

import java.util.Scanner;

public class InputUtility {
    private static Scanner scanner = new Scanner(System.in);

    public static int inputInt(View view, ResourceManager resourceManager) {
        view.showMessage(resourceManager.getMessage("INPUT_INT_DATA"));
        while (!scanner.hasNextInt()) {
            view.showMessage(resourceManager.getMessage("WRONG_INPUT"));
            scanner.next();
        }
        return scanner.nextInt();
    }
}