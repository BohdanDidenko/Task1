package com.epam.task11.task11_2.controller.strategy;

import com.epam.task11.task11_2.model.Triangle;

public class CalculateTotalAreaAllTrianglesStrategy extends Strategy {
    @Override
    public String execute() {
        return service.calculateTotalArea(Triangle.class);
    }
}
