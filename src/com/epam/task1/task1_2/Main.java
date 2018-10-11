package com.epam.task1.task1_2;

import com.epam.task1.task1_2.controller.Controller;

/**
 1.2. Напишите консольное приложение, которое находит все
 совершенные числа в диапазоне от 1 по некоторое заданное положительное
 число и выводит их (совершенное число – это число, которое равно сумме
 всех своих делителей, кроме самого себя. Например, 6 = 1+2+3).
 */

public class Main {
    public static void main(String[] args) {
        new Controller().run();
    }
}
