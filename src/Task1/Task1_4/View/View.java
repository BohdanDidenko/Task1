package Task1.Task1_4.View;

import Task1.Task1_4.Model.Model;

import java.util.Scanner;

public class View {
    private Scanner scanner = new Scanner(System.in);
    private int size;
    private int maxValue;
    private int[][] matrix;

    private static final String WRONG_INPUT = "Wrong input! Repeat please!";
    private static final String ENTER_HEIGHT_MATRIX = "Please enter a height of matrix";
    private static final String ENTER_MAX_VALUE_FOR_MATRIX_FILLING = "Please enter max value for matrix filling";
    private static final String SELECT_AN_ACTION = "Select an action: 1 - rotate matrix left, 2 - rotate matrix right, 0 - exit";

    public void run(Model model) {
        size = enterNumber(ENTER_HEIGHT_MATRIX);
        maxValue = enterNumber(ENTER_MAX_VALUE_FOR_MATRIX_FILLING);
        matrix = model.createMatrix(size, maxValue);
        printMatrix(matrix);
        selectAction(model);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    private int enterNumber(String massage) {
        int number;

        while (true) {
            printMessage(massage);
            if (scanner.hasNextInt() && (number = scanner.nextInt()) > 0) {
                return number;
            } else {
                printMessage(WRONG_INPUT);
                scanner.next();
                continue;
            }
        }
    }

    private void selectAction(Model model) {
        int choice;

        while (true) {
            printMessage(SELECT_AN_ACTION);

            if (scanner.hasNextInt())
                choice = scanner.nextInt();
            else {
                printMessage(WRONG_INPUT);
                scanner.next();
                continue;
            }

            switch (choice) {
                case 1: {
                    model.rotateMatrixLeft(matrix);
                    printMatrix(matrix);
                    break;
                }
                case 2: {
                    model.rotateMatrixRight(matrix);
                    printMatrix(matrix);
                    break;
                }
                case 0: {
                    return;
                }
                default: {
                    printMessage(WRONG_INPUT);
                    scanner.next();
                    continue;
                }
            }
        }
    }

    private void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

