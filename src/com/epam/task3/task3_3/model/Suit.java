package com.epam.task3.task3_3.model;

import com.epam.task3.task3_3.model.entity.MyEnum;

public class Suit extends MyEnum<Suit> {
    public static final Suit CLUBS = new Suit("clubs"); // трефы
    public static final Suit DIAMONDS = new Suit("diamonds"); // бубны
    public static final Suit HEARTS = new Suit("hearts"); // черви
    public static final Suit SPADES = new Suit("spades"); // пики

    private static final Suit[] VALUES = {CLUBS, DIAMONDS, HEARTS, SPADES};

    private Suit(String name) {
        super(name);
    }

    public static Suit[] values() {
        return VALUES;
    }

    public static Suit valueOf(String name) {
        for (Suit value : VALUES) {
            if (value.getName().equals(name)) return value;
         }
        return null;
    }

    public static int getEnumOrdinalByName(String name){
        for (Suit value : VALUES) {
            if (value.getName().equals(name)) return value.getOrdinal();
        }
        return new Integer(null);
    }

    public static String getEnumNameByOrdinal(int ordinal){
        for (Suit value : VALUES) {
            if (value.getOrdinal() == ordinal) return value.getName();
        }
        return null;
    }
}