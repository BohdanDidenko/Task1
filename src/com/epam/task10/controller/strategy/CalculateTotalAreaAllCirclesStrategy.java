package com.epam.task10.controller.strategy;

import com.epam.task10.model.Circle;

public class CalculateTotalAreaAllCirclesStrategy extends Strategy {
    @Override
    public String execute() {
        return service.calculateTotalArea(Circle.class);
    }
}
