package org.example;

public class Calculator {
    private double a;
    private double b;

    public Calculator(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double sum() {
        return a + b;
    }

    public double divide() {
        if (b == 0)
            throw new IllegalArgumentException();
        return a/b;
    }

    public double minus() {
        return a - b;
    }
}
