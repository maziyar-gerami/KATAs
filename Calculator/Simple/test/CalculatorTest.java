import org.calculator.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class CalculatorTest {

    @Test
    void testCalculator_whenActionIsPlus() {
        double a = 4;
        double b = 3;
        Calculator calc = new Calculator(a, b);
        assertEquals(7, calc.sum(), 0.001);
    }

    @Test
    void testCalculator_whenDenominatorIsNegative_throwException(){
        double a = 3;
        double b = 0;
        Calculator calc = new Calculator(a, b);
        assertThrows(IllegalArgumentException.class, calc::divide);
    }
}