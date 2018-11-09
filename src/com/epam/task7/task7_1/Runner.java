package com.epam.task7.task7_1;

import java.lang.reflect.Field;
import java.util.Scanner;

public class Runner {
    public void run() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter string");
        String string = "Hello";
        System.out.println(string);
        try {
            Class<?> clazz = string.getClass();
            Field field = clazz.getDeclaredField("value");
            field.setAccessible(true);
            field.set(string, "new value".toCharArray());
            System.out.println("new -> " + string);
            System.out.println("Hello");
            System.out.println("Hello".equals("new value"));
        }
        catch (NoSuchFieldException | IllegalAccessException e){
            e.getStackTrace();
        }
    }
}
