import org.example.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    @Test
    void testCalculator_whenActionIsPlus_thenSummationOfNumbers() {
        double a = 3;
        double b = 4;
        Calculator calc = new Calculator(a, b);
        double result = calc.sum();

        assertEquals(7, result, 0.0001);
    }
}
