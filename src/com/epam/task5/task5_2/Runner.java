package com.epam.task5.task5_2;

import java.io.IOException;
import java.util.*;

public class Runner {
    public void run(){
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new TreeSet<>();

        while (true) {
            try {
                int countOfElement = setCountOfElement(scanner);
                int startOfDiapason = setDiapason(countOfElement, scanner);
                initCollection(startOfDiapason, countOfElement, list);
                initCollection(startOfDiapason, countOfElement, set);
                printCollection(list);
                printCollection(set);
                return;
            } catch (NoSuchElementException | IOException e) {
                System.out.println("Wrong input! Repeat please!");
            }
        }
    }

    private int setCountOfElement(Scanner scanner){
        System.out.println("Enter the count of element for the list and set");
        return scanner.nextInt();
    }

    private int setDiapason(int countOfElement, Scanner scanner) throws IOException {
        System.out.println("Enter the start of diapason");
        int startOfDiapason = scanner.nextInt();
        System.out.println("Enter the end of diapason");
        int endOfDiapason = scanner.nextInt();
        if((endOfDiapason - startOfDiapason) < countOfElement)
            throw new IOException();
        return startOfDiapason;
    }

    private Collection<Integer> initCollection(int startOfDiapason, int countOfElement, Collection<Integer> collection){
        for (int i = startOfDiapason; i < startOfDiapason + countOfElement; i++) {
            collection.add(i);
        }
        return collection;
    }

    private <T>void printCollection(Collection<T> collection){
        System.out.println("This is " + collection.getClass().getSimpleName());
        for (T element : collection) {
            System.out.println(element);
        }
        System.out.println();
    }
}
