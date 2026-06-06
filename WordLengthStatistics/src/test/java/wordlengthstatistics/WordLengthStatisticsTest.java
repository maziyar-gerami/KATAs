package wordlengthstatistics;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class WordLengthStatisticsTest {

    public static Stream<Arguments> sentenceAndCountProvider() {
        return Stream.of(Arguments.of("This is java", new HashMap<>(Map.of(4, 2L, 2, 1L))),
                Arguments.of("   This  is java an    strong   language   ", new HashMap<>(Map.of(2, 2L, 4, 2L, 6, 1L, 8, 1L))));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"", " ", "      "})
    void wordLengthStatistics_whenSentenceIsEmpty_returnEmptyMap(String sentence){
        var result = WordLengthStatistics.calculate(sentence);
        assertEquals(Map.of(), result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Maziyar", " maziyar ", "   maziyar   "})
    void wordLengthStatistics_whenSentenceIsOneWord_returnEmptyMap(String sentence){
        var result = WordLengthStatistics.calculate(sentence);
        assertEquals(Map.of(7, 1L), result);
    }

    @ParameterizedTest
    @MethodSource(value = "sentenceAndCountProvider")
    void wordLengthStatistics_whenSentenceHasMoreWords_returnCountMap(String sentence, HashMap<Integer, Long> wordsCount){
        var result = WordLengthStatistics.calculate(sentence);
        assertEquals(wordsCount, result);
    }
}