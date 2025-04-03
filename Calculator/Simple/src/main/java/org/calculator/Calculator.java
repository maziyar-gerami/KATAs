package org.calculator;

public class Calculator {

    double a;
    double b;

    public Calculator(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double sum() {
        return a + b;
    }
}
