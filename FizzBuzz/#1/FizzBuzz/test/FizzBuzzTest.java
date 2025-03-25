import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FizzBuzzTest {

    @Test
    public void testFizzBuzz_whenNumberIsFizz() {
        int number = 3;
        FizzBuzz fizzBuzz = new FizzBuzz();
        String result = fizzBuzz.calculate(number);
        assertEquals("FIZZ", result);
    }

    @Test
    public void testFizzBuzz_whenNumberIsBuzz(){
        int number = 5;
        FizzBuzz fizzBuzz = new FizzBuzz();
        String result = fizzBuzz.calculate(number);
        assertEquals("BUZZ", result);
    }

    @Test
    public void testFizzBuzz_whenNumberIsFizzBuzz(){
        int number = 15;
        FizzBuzz fizzBuzz = new FizzBuzz();
        String result = fizzBuzz.calculate(number);
        assertEquals("FIZZBUZZ", result);
    }

    @Test
    public void testFizzBuzz_whenNumberIsNoFizzOrBuzz(){
        int number = 4;
        FizzBuzz fizzBuzz = new FizzBuzz();
        String result = fizzBuzz.calculate(number);
        assertEquals("4", result);
    }
}
