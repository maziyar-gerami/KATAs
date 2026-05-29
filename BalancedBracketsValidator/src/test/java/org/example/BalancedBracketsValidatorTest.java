package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class BalancedBracketsValidatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"ab", "you,", "  "})
    void balancedBracketValidator_whenInputIsEmptyOrWithoutBrackets_thenReturnTrue(String str){
        var result = BalancedBracketsValidator.isValid(str);
        assertTrue(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"(", "((", "{(", "{([])", "{([([)]}", "a{(b[(,[)]}}"})
    void balancedBracketValidator_whenStringIsImbalance_thenReturnFalse(String str){
        var result = BalancedBracketsValidator.isValid(str);
        assertFalse(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"()", "((()))", "{()}", "{([])}", "{([([])])}", "{a(b[c()])}"})
    void balancedBracketValidator_whenStringIsBalance_thenReturnTrue(String str){
        var result = BalancedBracketsValidator.isValid(str);
        assertTrue(result);
    }

}