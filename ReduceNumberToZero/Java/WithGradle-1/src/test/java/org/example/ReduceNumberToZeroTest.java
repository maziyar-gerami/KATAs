package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReduceNumberToZeroTest {

    @Test
    void testReduceNumberToZero_whenNumberIsZero_returnZero() {
        int number = 0;
        ReduceNumberToZero reduceNumberToZero = new ReduceNumberToZero(number);
        int result = reduceNumberToZero.reduceToZero();

        assertEquals(0, result);
    }

    @Test
    void testReduceNumberToZero_whenNumberIsSix_thenResultWillBeFour(){
        int number = 6;
        ReduceNumberToZero reduceNumberToZero = new ReduceNumberToZero(number);
        int result = reduceNumberToZero.reduceToZero();

        assertEquals(4, result);
    }

    @Test
    void testReduceNumberToZero_whenNumberIsFourteen_thenResultWillBeSix(){
        int number = 14;
        ReduceNumberToZero reduceNumberToZero = new ReduceNumberToZero(number);
        int result = reduceNumberToZero.reduceToZero();

        assertEquals(6, result);
    }
}
