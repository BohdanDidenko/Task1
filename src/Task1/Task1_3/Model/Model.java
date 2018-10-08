package Task1.Task1_3.Model;

public class Model {
    public int[][] buildPyramid(int height) {
        int matrix[][] = new int[height][2 * height - 1];

        //заполняем левую часть пирамиды
        for (int i = 0; i < height; i++) {
            int point;
            for (int j = 0; j < height; j++) {
                point = 2 - height + j + i;
                if (point > 0) {
                    matrix[i][j] = point;
                }
            }
        }

        //заполняем правую часть пирамиды
        for (int i = 0; i < height; i++) {
            int point;
            for (int j = height; j < 2 * height - 1; j++) {
                point = -j + i + height;
                if (point > 0) {
                    matrix[i][j] = point;
                }
            }
        }
        return matrix;
    }
}
