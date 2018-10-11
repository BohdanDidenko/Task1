package com.epam.task1.task1_4.view;

public class View {
    public static final String WRONG_INPUT = "Wrong input! Repeat please!";
    public static final String ENTER_HEIGHT_MATRIX = "Please enter a height of matrix";
    public static final String ENTER_MAX_VALUE_FOR_MATRIX_FILLING = "Please enter max value for matrix filling";
    public static final String SELECT_AN_ACTION = "Select an action: 1 - rotate matrix left, 2 - rotate matrix right, 0 - exit";

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

