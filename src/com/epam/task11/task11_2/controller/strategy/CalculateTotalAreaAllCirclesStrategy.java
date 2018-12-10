package com.epam.task11.task11_2.controller.strategy;

import com.epam.task11.task11_2.model.Circle;

public class CalculateTotalAreaAllCirclesStrategy extends Strategy {
    @Override
    public String execute() {
        return service.calculateTotalArea(Circle.class);
    }
}
