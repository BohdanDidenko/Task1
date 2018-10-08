package Task1.Task1_4.Model;

public class Model {
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
