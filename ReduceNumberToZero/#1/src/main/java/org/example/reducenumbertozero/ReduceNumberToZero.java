package org.example.reducenumbertozero;

public class ReduceNumberToZero {

    private int steps = 0;

    public int getSteps() {
        return steps;
    }

    public int calculate(int number) {
        return (number == 0)
                ? 0
                : calculate(calcSteps(number));
    }

    private int calcSteps(int n) {
        steps++;
        return n % 2 == 0 ? n / 2 : n - 1;
    }
}
