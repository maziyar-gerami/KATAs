package org.palindrome;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PalindromeTest {

    @Test
    public void testPalindrome_whenStringIsPalindrome(){
        String s = "Madam";
        boolean result = Palindrome.calculate(s);
        assertTrue(result);
    }

    @Test
    public void testPalindrome_whenStringIsNotPalindrome(){
        String s = "maziyar";
        boolean result = Palindrome.calculate(s);
        assertFalse(result);
    }
}
