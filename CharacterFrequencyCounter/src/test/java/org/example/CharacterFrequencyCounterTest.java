package org.example;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;


import static org.assertj.core.api.Assertions.assertThat;

class CharacterFrequencyCounterTest {

    @Test
    void counter_whenTextIsSimple_countIt() {
        String str = "Hello World! 22";
        var expectedResult = new LinkedHashMap<>(
                Map.of('!', 1, '2', 2, 'd', 1, 'e', 1, 'H', 1, 'l', 3, 'o', 2, 'r', 1, 'W', 1));

        var result = CharacterFrequencyCounter.countCharacters(str);

        assertThat(result).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void counter_whenTextIsNullOrEmpty(String str){
        var result = CharacterFrequencyCounter.countCharacters(str);

        assertThat(result).isEmpty();
    }

}