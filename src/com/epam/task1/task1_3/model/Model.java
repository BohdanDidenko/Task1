package com.epam.task1.task1_3.model;

public class Model {
    public int[][] buildPyramid(int height) {
        int pyramid[][] = new int[height][2 * height - 1];

        fillLeftSide(pyramid, height);
        fillRightSide(pyramid, height);

        return pyramid;
    }

    private void fillLeftSide(int[][] pyramid, int height){
        for (int i = 0; i < height; i++) {
            int point;
            for (int j = 0; j < height; j++) {
                point = 2 - height + j + i;
                if (point > 0) {
                    pyramid[i][j] = point;
                }
            }
        }
    }

    private void fillRightSide (int[][] pyramid, int height){
        for (int i = 0; i < height; i++) {
            int point;
            for (int j = height; j < 2 * height - 1; j++) {
                point = -j + i + height;
                if (point > 0) {
                    pyramid[i][j] = point;
                }
            }
        }
    }
}
