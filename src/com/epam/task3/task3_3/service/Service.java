package com.epam.task3.task3_3.service;

import com.epam.task3.task3_3.model.Suit;
import com.epam.task3.task3_3.model.entity.MyEnum;
import com.epam.task3.task3_3.view.SuitView;

import java.util.Scanner;

public class Service {
    private SuitView view;

    public Service(SuitView view) {
        this.view = view;
    }

    public int inputNumber(String message, Scanner scanner){
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

    public void compareEnum(){
        view.getScanner().nextLine();
        view.printMessage(view.ENTER_MYENUM_NAME);
        String firstName = view.getScanner().nextLine();
        view.printMessage(view.ENTER_MYENUM_NAME);
        String secondName = view.getScanner().nextLine();
        if((Suit.valueOf(firstName).compareTo(Suit.valueOf(secondName))) > 0)
            view.printMessage(secondName + " preceded " + firstName);
        else view.printMessage(firstName + " preceded " + secondName);
    }

    public String getEnumNameFromUser(){
        view.getScanner().nextLine();
        view.printMessage(view.ENTER_MYENUM_NAME);
        return view.getScanner().nextLine();
    }

    public int getEnumOrdinalFromUser(){
        view.getScanner().nextLine();
        view.printMessage(view.ENTER_MYENUM_ORDINAL);
        return view.getScanner().nextInt();
    }

    public void resultHandler(int result) {
        if (result > 0)
            view.printMessage(String.valueOf(result));
        else
            view.printMessage(view.NO_RESULT);
    }

    public void resultHandler(String result) {
        if (result != null && result.equals("") == false)
            view.printMessage(result);
        else
            view.printMessage(view.NO_RESULT);
    }

    public <E extends MyEnum<E>>void resultHandler(E result) {
        if (result != null)
            view.printMyEnum(result);
        else
            view.printMessage(view.NO_RESULT);
    }

    public <E>void resultHandler(E[] result) {
        if (result.length > 0)
            view.printArray(result);
        else
            view.printMessage(view.NO_RESULT);
    }
}
