package com.epam.task7.task7_2;

public class UnaryOperation {
    private double value;

    public UnaryOperation() {
        this(100.0);
    }

    public UnaryOperation(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void incremente(){
        value++;
    }

    public void decremente(){
        value--;
    }

    public void unsigned(){ value = -value; }

    @Override
    public String toString() {
        return "UnaryOperation{" +
                "value=" + value +
                '}';
    }
}
