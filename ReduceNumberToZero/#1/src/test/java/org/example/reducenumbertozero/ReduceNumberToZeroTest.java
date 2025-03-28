package org.example.reducenumbertozero;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReduceNumberToZeroTest {

    @Test
    void testReduceNumberToZero_fourteen() {
        int number = 14;
        ReduceNumberToZero reduceNumberToZero = new ReduceNumberToZero();
        reduceNumberToZero.calculate(number);
        assertEquals(6, reduceNumberToZero.getSteps());
    }

    @Test
    void testReduceNumberToZero_eight() {
        int number = 8;
        ReduceNumberToZero reduceNumberToZero = new ReduceNumberToZero();
        reduceNumberToZero.calculate(number);
        assertEquals(4, reduceNumberToZero.getSteps());
    }

    @Test
    void testReduceNumberToZero_oneHundredAndTwentyThree() {
        int number = 123;
        ReduceNumberToZero reduceNumberToZero = new ReduceNumberToZero();
        reduceNumberToZero.calculate(number);
        assertEquals(12, reduceNumberToZero.getSteps());
    }

    @Test
    void testReduceNumberToZero_zero() {
        int number = 0;
        ReduceNumberToZero reduceNumberToZero = new ReduceNumberToZero();
        reduceNumberToZero.calculate(number);
        assertEquals(0, reduceNumberToZero.getSteps());
    }
}
