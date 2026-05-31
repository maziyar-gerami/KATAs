package service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TopKFrequentElementsTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void topKFrequent_whenKisNotValid_returnEmptyList(int k) {
        var result = TopKFrequentElements.findTopK(List.of(1, 2, 3), k);
        assertEquals(List.of(), result);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void topKFrequent_whenKIsGreaterThanNumbersListSize_returnTheOriginalList(List<Integer> numbers) {
        var result = TopKFrequentElements.findTopK(numbers, 3);
        assertEquals(List.of(), result);
    }

    @ParameterizedTest
    @MethodSource("kIsEqualOrGreaterThanDistinctNumbersProvider")
    void topKFrequent_whenNumbersListNotValid_returnEmptyList(List<Integer> numbers, int k) {
        var expectedResult = List.of(1, 2, 3);
        var result = TopKFrequentElements.findTopK(numbers, k);
        assertEquals(expectedResult, result);
    }

    public static Stream<Arguments> kIsEqualOrGreaterThanDistinctNumbersProvider() {
        return Stream.of(Arguments.of(List.of(1, 2, 3), 3),
                Arguments.of(List.of(1, 2, 3), 5),
                Arguments.of(List.of(1, 2, 3, 2, 3), 3));
    }
}