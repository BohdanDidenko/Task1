package com.epam.task11.task11_2.controller.strategy;

import java.util.Arrays;
import java.util.Collections;

public class SortByIncreasingAreaOfFiguresStrategy extends Strategy {
    @Override
    public String execute() {
        service.sortByIncreasingAreaOfFigures();
        return service.getShapes().toString();
    }
}
