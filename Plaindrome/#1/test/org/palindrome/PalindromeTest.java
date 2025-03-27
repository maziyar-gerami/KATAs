package org.palindrome;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PalindromeTest {

    @Test
    public void givenOddString_whenIsPalindrome_thenReturnTrue() {
        String s = "Madam";
        boolean result = Palindrome.calculate(s);
        assertTrue(result);
    }

    @Test
    public void givenEvenString_whenIsPalindrome_thenReturnTrue() {
        String s = "Maam";
        boolean result = Palindrome.calculate(s);
        assertTrue(result);
    }

    @Test
    public void givenOddString_whenIsNotPalindrome_thenReturnFalse() {
        String s = "Palindrome";
        boolean result = Palindrome.calculate(s);
        assertFalse(result);
    }
}
