package com.epam.task1.task1_3.view;

import com.epam.task1.task1_3.model.Model;

import java.util.Scanner;

public class View {
    public static final String WRONG_INPUT = "Wrong input! Repeat please!";
    public static final String ENTER_HEIGHT_PYRAMID = "Please enter a height of Pyramid from 1 to 9";

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printPyramid (int matrix [][]) {
        int width = matrix[0].length;
        int height = matrix.length;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] != 0){
                    System.out.print(matrix[i][j] + " ");
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
