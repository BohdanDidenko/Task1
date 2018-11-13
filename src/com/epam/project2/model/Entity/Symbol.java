package com.epam.project2.model.Entity;

public abstract class Symbol {
    private char symbol;

    public Symbol() {
    }

    public Symbol(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
}
