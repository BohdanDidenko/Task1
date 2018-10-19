package com.epam.task3.task3_3.controller;

import com.epam.task3.task3_3.model.Suit;
import com.epam.task3.task3_3.model.entity.MyEnum;
import com.epam.task3.task3_3.view.SuitView;
import java.util.Scanner;

public class Controller {
    private SuitView view = new SuitView();

    public void run(){
        selectAction();
    }

    public void selectAction() {
        while (true) {
            int choice = inputNumber(view.SELECT_AN_ACTION , view.getScanner());
            switch (choice) {
                case 1: {
                    resultHandler(Suit.values());
                    break;
                }
                case 2: {
                    view.getScanner().nextLine();
                    view.printMessage(view.ENTER_MYENUM_NAME);
                    resultHandler(Suit.valueOf(view.getScanner().nextLine()));
                    break;
                }
                case 3: {
                    view.getScanner().nextLine();
                    view.printMessage(view.ENTER_MYENUM_NAME);
                    resultHandler(Suit.getEnumOrdinalByName(view.getScanner().nextLine()));
                    break;
                }
                case 4: {
                    view.getScanner().nextLine();
                    view.printMessage(view.ENTER_MYENUM_ORDINAL);
                    resultHandler(Suit.getEnumNameByOrdinal(view.getScanner().nextInt()));
                    break;
                }
                case 5: {
                    compareEnum();
                    break;
                }
                case 0: {
                    return;
                }
                default: {
                    view.printMessage(view.WRONG_INPUT);
                    view.getScanner().next();
                }
            }
        }
    }

    private int inputNumber(String message, Scanner scanner){
        while (true) {
            view.printMessage(message);

            if (scanner.hasNextInt())
                return scanner.nextInt();
            else {
                view.printMessage(view.WRONG_INPUT);
                scanner.next();
            }
        }
    }

    private void compareEnum(){
        view.getScanner().nextLine();
        view.printMessage(view.ENTER_MYENUM_NAME);
        String firstName = view.getScanner().nextLine();
        view.printMessage(view.ENTER_MYENUM_NAME);
        String secondName = view.getScanner().nextLine();
        if((Suit.valueOf(firstName).compareTo(Suit.valueOf(secondName))) > 0)
            view.printMessage(secondName + " preceded " + firstName);
        else view.printMessage(firstName + " preceded " + secondName);
    }

    private void resultHandler(int result) {
        if (result > 0)
            view.printMessage(String.valueOf(result));
        else
            view.printMessage(view.NO_RESULT);
    }

    private void resultHandler(String result) {
        if (result != null && result.equals("") == false)
            view.printMessage(result);
        else
            view.printMessage(view.NO_RESULT);
    }

    private <E extends MyEnum<E>>void resultHandler(E result) {
        if (result != null)
            view.printMyEnum(result);
        else
            view.printMessage(view.NO_RESULT);
    }

    private <E>void resultHandler(E[] result) {
        if (result.length > 0)
            view.printArray(result);
        else
            view.printMessage(view.NO_RESULT);
    }
}
