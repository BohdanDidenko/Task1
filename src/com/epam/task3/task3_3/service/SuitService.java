package com.epam.task3.task3_3.service;

import com.epam.task3.task3_3.model.Suit;

public class SuitService {

    public String compareEnum(String firstName, String secondName){
        if((Suit.valueOf(firstName).compareTo(Suit.valueOf(secondName))) > 0)
            return secondName + " preceded " + firstName;
        else
            return firstName + " preceded " + secondName;
    }

    public Integer getEnumOrdinalByName(String name){
        for (Suit value : Suit.values()) {
            if (value.getName().equals(name)) return value.getOrdinal();
        }
        return null;
    }

    public String getEnumNameByOrdinal(Integer ordinal){
        for (Suit value : Suit.values()) {
            if (value.getOrdinal() == ordinal) return value.getName();
        }
        return null;
    }
}
