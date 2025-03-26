import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class FizzBuzzTest {

    @Test
    public void FizzBuzzTest_FizzBuzz(){
        int number = 15;
        var result = FizzBuzzCalculator.calculate(number);
        assertEquals(FizzBuzz.FIZZ_BUZZ, result);
    }

    @Test
    public void FizzBuzzTest_Fizz(){
        int number = 12;
        var result = FizzBuzzCalculator.calculate(number);
        assertEquals(FizzBuzz.FIZZ, result);
    }

    @Test
    public void FizzBuzzTest_Buzz(){
        int number = 5;
        var result = FizzBuzzCalculator.calculate(number);
        assertEquals(FizzBuzz.BUZZ, result);
    }

    @Test
    public void FizzBuzzTest_number(){
        int number = 2;
        var result = FizzBuzzCalculator.calculate(number);
        assertNull(result);
    }
}
