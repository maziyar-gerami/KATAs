import org.example.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    @Test
    void testCalculator_whenActionIsPlus_thenSummationOfNumbers() {
        double a = 3;
        double b = 4;
        Calculator calc = new Calculator(a, b);
        double result = calc.sum();

        assertEquals(7, result, 0.0001);
    }


    @Test
    void testCalculator_whenActionIsDivideAndDenominatorIsZero_thenThrowsException() {
        double a = 3;
        double b = 0;
        Calculator calc = new Calculator(a, b);

        assertThrows(IllegalArgumentException.class, calc::divide);
    }

    @Test
    void testCalculator_whenDenominatorIsValid_thenDivide() {
        double a = 6;
        double b = 3;
        Calculator calc = new Calculator(a, b);
        double result = calc.divide();

        assertEquals(2, result, 0.0001);
    }

    @Test
    void testCalculator_whenActionIsMinus_thenSubtractionOfNumbers() {
        double a = 3;
        double b = 4;
        Calculator calc = new Calculator(a, b);
        double result = calc.minus();

        assertEquals(-1, result, 0.0001);
    }

    @Test
    void testCalculator_whenActionIsMultiply_thenMultiplicationOfNumbers() {
        double a = 3;
        double b = 4;
        Calculator calc = new Calculator(a, b);
        double result = calc.multiply();

        assertEquals(12, result, 0.0001);
    }
}
