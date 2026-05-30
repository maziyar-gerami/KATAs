package service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AnagramDetector {

    public static boolean isAnagram(String first, String second) {
        if (first == null || second == null)
            return false;

        String firstNormalized = getNormalized(first);
        String secondNormalized = getNormalized(second);

        if (firstNormalized.length() != secondNormalized.length())
            return false;

        var firstFrequencies = getFrequencies(firstNormalized);
        var secondFrequencies = getFrequencies(secondNormalized);

        return firstFrequencies.equals(secondFrequencies);
    }

    private static Map<Integer, Long> getFrequencies(String firstNormalized) {
        return firstNormalized
                .toLowerCase()
                .chars()
                .boxed()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));
    }

    private static String getNormalized(String first) {
        return first
                .chars()
                .filter(Character::isLetterOrDigit)
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();
    }
}
