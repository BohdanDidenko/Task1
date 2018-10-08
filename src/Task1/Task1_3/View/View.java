package Task1.Task1_3.View;

import Task1.Task1_3.Model.Model;

import java.util.Scanner;

public class View {
    private Scanner scanner = new Scanner(System.in);
    private int height;

    private static final String WRONG_INPUT = "Wrong input! Repeat please!";
    private static final String ENTER_HEIGHT_PYRAMID = "Please enter a height of Pyramid from 1 to 9";

    public void run(Model model) {
        enterHeight();
        printPyramid(model.buildPyramid(height));
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    private void enterHeight() {
        while (true) {
            printMessage(ENTER_HEIGHT_PYRAMID);
            if (scanner.hasNextInt() && (height = scanner.nextInt()) > 0 && height < 10) {
                break;
            } else {
                printMessage(WRONG_INPUT);
                scanner.next();
                continue;
            }
        }
    }

    private void printPyramid (int matrix [][]) {
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
