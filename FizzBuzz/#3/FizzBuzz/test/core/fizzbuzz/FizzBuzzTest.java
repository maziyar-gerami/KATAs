package core.fizzbuzz;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class FizzBuzzTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setup(){
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testFizzBuzz_testEnum() {
        assertEquals("FIZZ", PlayFizzBuzz.FizzBuzz.FIZZ.name());
        assertEquals("BUZZ", PlayFizzBuzz.FizzBuzz.BUZZ.name());
        assertEquals("FIZZ_BUZZ", PlayFizzBuzz.FizzBuzz.FIZZ_BUZZ.name());
    }

    @Test
    public void testPlayFizzBuzz_Fizz() {
        int number = 3;
        PlayFizzBuzz.play(number);

        assertEquals("FIZZ", outputStreamCaptor.toString());
    }

    @Test
    public void testPlayFizzBuzz_Buzz() {
        int number = 5;
        PlayFizzBuzz.play(number);

        assertEquals("BUZZ", outputStreamCaptor.toString());
    }

    @Test
    public void testPlayFizzBuzz_FizzBuzz() {
        int number = 15;
        PlayFizzBuzz.play(number);

        assertEquals("FIZZ_BUZZ", outputStreamCaptor.toString());
    }

    @After
    public void restoreStream(){
        System.setOut(originalOut);
    }
}
