package com.epam.task7.task7_3_7_5;

@FunctionalInterface
public interface ConvertString {
    String convert(String str);

    default boolean isNull(String string){
        return string == null || string.equals("");
    }
}
