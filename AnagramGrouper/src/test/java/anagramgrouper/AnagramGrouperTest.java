package anagramgrouper;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


class AnagramGrouperTest {

    public static Stream<Arguments> wordsProvider() {
        return Stream.of(Arguments.of(List.of("Listen"), List.of(List.of("Listen"))),
                Arguments.of(List.of("Listen", "Eat"), List.of(List.of("Eat"), List.of("Listen"))),
                Arguments.of(List.of("Listen", "Eat", "Silent"), List.of(List.of("Eat"), List.of("Listen", "Silent"))),
                Arguments.of(List.of("Listen", "Eat", "Tea", "Silent"), List.of(List.of("Eat", "Tea"), List.of("Listen", "Silent"))));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void angramGrouper_whenWordsListIsEmpty_returnEmptyList(List<String> words) {
        var result = AnagramGrouper.group(words);
        assert result != null;
        assertTrue (result.isEmpty());
    }

    @ParameterizedTest
    @MethodSource("wordsProvider")
    void angramGrouper_whenValidWords_returnNgramGrouped(List<String> words, List<List<String>> expectedResult) {
        var result = AnagramGrouper.group(words);
        assertEquals(expectedResult, result);
    }

}