package com.epam.task1.task1_4.model;

public class Model {
    private int size;
    private int maxValue;
    private int[][] matrix;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int[][] createMatrix(int size, int maxValue){
        int[][] matrix = new int[size][size];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = (int) ((Math.random()*maxValue) - (maxValue / 2));
            }
        }
        return matrix;
    }

    public void rotateMatrixLeft(int[][] matrix){
        int temp;

        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = i; j < (matrix.length - 1 - i); j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][matrix.length - 1 - i];
                matrix[j][matrix.length - 1 - i] = matrix[matrix.length - 1 - i][matrix.length - 1 - j];
                matrix[matrix.length - 1 - i][matrix.length - 1 - j] = matrix[matrix.length - 1 - j][i];
                matrix[matrix.length - 1 - j][i] = temp;

            }
        }
    }

    public void rotateMatrixRight(int[][] matrix){
        int temp;

        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = i; j < (matrix.length - 1 - i); j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - 1 - j][i];
                matrix[matrix.length - 1 - j][i] = matrix[matrix.length - 1 - i][matrix.length - 1 - j];
                matrix[matrix.length - 1 - i][matrix.length - 1 - j] = matrix[j][matrix.length - 1 - i];
                matrix[j][matrix.length - 1 - i] = temp;
            }
        }
    }
}
