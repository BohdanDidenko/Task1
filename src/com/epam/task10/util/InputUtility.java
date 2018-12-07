package com.epam.task10.util;

import com.epam.task10.view.View;

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

    public static String inputString(View view, ResourceManager manager) {
        view.showMessage(manager.getMessage("INPUT_STRING_DATA"));
        return scanner.next();
    }
}