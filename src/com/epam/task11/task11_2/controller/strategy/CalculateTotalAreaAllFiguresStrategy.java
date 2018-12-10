package com.epam.task11.task11_2.controller.strategy;

public class CalculateTotalAreaAllFiguresStrategy extends Strategy {
    @Override
    public String execute() {
        return String.valueOf(service.calculateTotalArea());
    }
}
