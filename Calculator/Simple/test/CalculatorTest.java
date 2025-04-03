import org.calculator.Calculator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    @Test
    public void testCalculator_whenActionIsPlus() {
        double a = 4;
        double b = 3;
        Calculator calc = new Calculator(a, b);
        assertEquals(7, calc.sum(), 0.001);
    }
}