package com.epam.task11.task11_2.controller.strategy;

import java.util.Arrays;

public class SortByColorOfFiguresStrategy extends Strategy {
    @Override
    public String execute() {
        service.sortByColorOfFigures();
        return service.getShapes().toString();
    }
}
