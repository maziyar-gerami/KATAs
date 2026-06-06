package filteredwordfrequency;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FilteredWordFrequencyTest {

    public static Stream<Arguments> validInputsAndExpectedResult() {
        return Stream.of(Arguments.of("text", 1, 5, Map.of(4, 1L)),
                Arguments.of("this is a text", 2, 4, Map.of(4, 2L, 2, 1L)),
                Arguments.of("  Java is   powerful and fun ", 2, 5, Map.of(4, 1L, 2, 1L, 3, 2L)));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void filteredWordFrequency_whenTextIsEmpty_returnEmptyMap(String text) {
        var result = FilteredWordFrequency.calculate(text, 1, 10);
        assertEquals(Map.of(), result);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -2})
    void filteredWordFrequency_whenMinLengthIsNotValid_returnEmptyMap(int minLength) {
        var result = FilteredWordFrequency.calculate("text", minLength, 10);
        assertEquals(Map.of(), result);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 3, 0})
    void filteredWordFrequency_whenMaxLengthIsNotValid_returnEmptyMap(int maxLength) {
        var result = FilteredWordFrequency.calculate("text", 3, maxLength);
        assertEquals(Map.of(), result);
    }

    @ParameterizedTest
    @MethodSource(value = "validInputsAndExpectedResult")
    void filteredWordFrequency_whenEverythingIsOk_returnMapOfResult(String text, int minLength, int maxLength, Map<Integer, Long> expectedResult) {
        var result = FilteredWordFrequency.calculate(text, minLength, maxLength);
        assertEquals(expectedResult, result);
    }
}