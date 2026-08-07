package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimeCheckTest {

    @Test
    void isPrimeTest_whenInput_Not_Prime() {
        int input = 4;

        boolean result = PrimeCheck.isPrime(input);

        assertFalse(result);
    }

    @Test
    void isPrimeTest_whenInput_is_Prime(){
        int input = 3;

        boolean res = PrimeCheck.isPrime(input);

        assertTrue(res);
    }
}