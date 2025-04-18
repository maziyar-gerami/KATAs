package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimeCheckTest {

    @Test
    void whenInput_isNotPrime() {
        int input = 4;

        boolean result = PrimeCheck.isPrime(input);

        assertFalse(result);
    }

    @Test
    void whenInput_isPrime(){
        int input = 3;

        boolean res = PrimeCheck.isPrime(input);

        assertTrue(res);
    }
}