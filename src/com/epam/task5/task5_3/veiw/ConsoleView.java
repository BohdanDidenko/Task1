package com.epam.task5.task5_3.veiw;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class ConsoleView implements View<String, Scanner, String, String>, ConsoleMessage {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public Scanner getRequestFromUser() {
        return scanner;
    }

    @Override
    public void showMenu() {
        showMessage(ConsoleMessage.MAIN_MENU);
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }
}
