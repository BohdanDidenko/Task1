package com.epam.task10.controller.strategy;

import com.epam.task10.model.Triangle;

public class CalculateTotalAreaAllTrianglesStrategy extends Strategy {
    @Override
    public String execute() {
        return service.calculateTotalArea(Triangle.class);
    }
}
