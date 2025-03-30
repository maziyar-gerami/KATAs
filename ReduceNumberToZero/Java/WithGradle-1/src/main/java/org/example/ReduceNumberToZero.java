package org.example;

public class ReduceNumberToZero {

    private int number;
    private int steps;

    public ReduceNumberToZero(int number) {
        this.number = number;
        this.steps = 0;
    }

    int reduceToZero() {
        if (number == 0)
            return steps;

        steps++;
        number = (number % 2 == 0)
                ? number / 2
                : number - 1;
        return reduceToZero();
    }
}
