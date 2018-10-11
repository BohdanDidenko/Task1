package com.epam.task1.task1_2.model;

import java.util.ArrayList;

public class Model {
    public  ArrayList<Integer> searchPerfectNumbers (int border){
        ArrayList<Integer> perfectNumbers = new ArrayList<>();

        for (int i = 1; i < border; i++ ){
            if (isPerfect(i)){
                perfectNumbers.add(i);
            }
        }
        return perfectNumbers;
    }

    private boolean isPerfect (int number){
        ArrayList<Integer> divaders = new ArrayList<Integer>();
        int sum = 0;

        for (int i = 1; i < number; i++){
            if (number % i == 0){
                divaders.add(i);
            }
        }

        for (int i: divaders){
            sum+=i;
        }

        return sum == number;
    }
}
