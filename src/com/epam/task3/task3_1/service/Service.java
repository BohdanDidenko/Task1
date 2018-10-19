package com.epam.task3.task3_1.service;

import com.epam.task3.task3_1.model.GameRoom;
import com.epam.task3.task3_1.model.entity.KidsToy;
import com.epam.task3.task3_1.view.ToysView;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Service {
    private GameRoom<KidsToy> model;
    private ToysView view;

    public Service(GameRoom<KidsToy> model, ToysView view) {
        this.model = model;
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

    public <E>ArrayList searchBySpecifiedCriteria(ArrayList<E> list) {
        String title = "";
        String manufacturer = "";
        String material = "";
        double price = -1.0;
        int warrantyDays = -1;
        int packingWidth = -1;
        int packingHeight = -1;
        String ageGroup = "";

        while (true) {
            try {
                int choice = inputNumber(view.SELECT_SEARCH_CRITERIA, view.getScanner());
                switch (choice) {
                    case 1: {
                        view.printMessage(view.SEARCH_BY_TITLE);
                        view.getScanner().nextLine();
                        title = view.getScanner().nextLine();
                        break;
                    }
                    case 2: {
                        view.printMessage(view.SEARCH_BY_MANUFACTURER);
                        view.getScanner().nextLine();
                        manufacturer = view.getScanner().nextLine();
                        break;
                    }
                    case 3: {
                        view.printMessage(view.SEARCH_BY_MATERIAL);
                        view.getScanner().nextLine();
                        material = view.getScanner().nextLine();
                        break;
                    }
                    case 4: {
                        view.printMessage(view.SEARCH_BY_PRICE);
                        view.getScanner().nextLine();
                        price = view.getScanner().nextDouble();
                        break;
                    }
                    case 5: {
                        view.printMessage(view.SEARCH_BY_WARRANTY_DAYS);
                        view.getScanner().nextLine();
                        warrantyDays = view.getScanner().nextInt();
                        break;
                    }
                    case 6: {
                        view.printMessage(view.SEARCH_BY_PACKING_WIDTH);
                        view.getScanner().nextLine();
                        packingWidth = view.getScanner().nextInt();
                        break;
                    }
                    case 7: {
                        view.printMessage(view.SEARCH_BY_PACKING_HEIGHT);
                        view.getScanner().nextLine();
                        packingHeight = view.getScanner().nextInt();
                        break;
                    }
                    case 8: {
                        view.printMessage(view.SEARCH_BY_AGE_GROUP);
                        view.getScanner().nextLine();
                        ageGroup = view.getScanner().nextLine();
                        break;
                    }
                    case 0: {
                        return model.searchForKidsToysAtTheUserRequest(title, manufacturer, material,
                                price, warrantyDays, packingWidth, packingHeight, ageGroup);
                    }
                    default: {
                        view.printMessage(view.WRONG_INPUT);
                        view.getScanner().next();
                    }
                }
            }
            catch(NumberFormatException | InputMismatchException e){
                view.printMessage(view.WRONG_INPUT);
            }
        }
    }

    public <E>void sortByTitle(ArrayList<E> list) {
        model.sort((o1, o2) -> o1.getTitle().compareTo(o2.getTitle()));
    }

    public <E>void sortByManufacturer(ArrayList<E> list){
        model.sort((o1,o2) -> o1.getManufacturer().compareTo(o2.getManufacturer()));
    }

    public <E>void sortByMaterial(ArrayList<E> list){
        model.sort((o1, o2) -> o1.getMaterial().compareTo(o2.getMaterial()));
    }

    public <E>void sortByPrice(ArrayList<E> list){
        model.sort((o1, o2) -> (int)(o1.getPrice() - o2.getPrice()));
    }

    public <E>void sortByWarrantyDays(ArrayList<E> list){
        model.sort((o1, o2) -> o1.getWarrantyDays() - o2.getWarrantyDays());
    }

    public <E>void resultHandler(ArrayList<E> result) {
        if (result.size() > 0)
            view.printList(result);
        else
            view.printMessage(view.NO_RESULT);
    }

    public <E>void resultHandler(String result) {
        if (result != null && result.equals("") != true)
            view.printMessage(result);
        else
            view.printMessage(view.NO_RESULT);
    }
}
