package com.epam.task10.controller.strategy;

import java.util.Arrays;

public class SortByColorOfFiguresStrategy extends Strategy {
    @Override
    public String execute() {
        service.sortByColorOfFigures();
        return Arrays.toString(service.getShapes());
    }
}
