package service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class AnagramDetectorTest {

    @ParameterizedTest
    @MethodSource("nullInputProvider")
    void angramDetectorTest_whenOneOfTheInputsIsNull_thenReturnFalse(String in1, String in2) {
        assertFalse(AnagramDetector.isAnagram(in1, in2));
    }

    @ParameterizedTest
    @MethodSource("differentInputSizeProvider")
    void angramDetectorTest_whenTheLengthOfInputsAreDifferent_thenReturnFalse(String firstInput, String secondInput) {
        assertFalse(AnagramDetector.isAnagram(firstInput, secondInput));
    }

    @ParameterizedTest
    @MethodSource("inCorrectInputProvider")
    void angramDetectorTest_whenIsNotAngram_thenReturnFalse(String firstInput, String secondInput) {
        assertFalse(AnagramDetector.isAnagram(firstInput, secondInput));
    }

    @ParameterizedTest
    @MethodSource("correctInputProvider")
    void angramDetectorTest_whenIsAngram_thenReturnTrue(String firstInput, String secondInput) {
        assertTrue(AnagramDetector.isAnagram(firstInput, secondInput));
    }

    public static Stream<Arguments> nullInputProvider() {
        return Stream.of(Arguments.of(null, null),
                Arguments.of(null, "string"),
                Arguments.of("string", null));
    }

    public static Stream<Arguments> differentInputSizeProvider() {
        return Stream.of(Arguments.of("", "1"),
                Arguments.of("aa", "1"),
                Arguments.of("1", "aa"));
    }

    public static Stream<Arguments> inCorrectInputProvider() {
        return Stream.of(Arguments.of("hello", "world"),
                Arguments.of("java", "javascript"),
                Arguments.of("abc", "abcd"));
    }

    public static Stream<Arguments> correctInputProvider() {
        return Stream.of(Arguments.of("hi", "ih"),
                Arguments.of("listen", "silent"),
                Arguments.of("listen", "silent"),
                Arguments.of("triangle", "integral"),
                Arguments.of("triangle", "integral"),
                Arguments.of("Dormitory", "Dirty Room!"),
                Arguments.of("rail safety", "fairy tales"));
    }

}