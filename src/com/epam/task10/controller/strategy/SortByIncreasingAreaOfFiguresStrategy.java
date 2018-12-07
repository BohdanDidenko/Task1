package com.epam.task10.controller.strategy;

import java.util.Arrays;

public class SortByIncreasingAreaOfFiguresStrategy extends Strategy {
    @Override
    public String execute() {
        service.sortByIncreasingAreaOfFigures();
        return Arrays.toString(service.getShapes());
    }
}
