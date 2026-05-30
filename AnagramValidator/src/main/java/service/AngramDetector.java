package service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.function.Function;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AngramDetector {

    public static boolean isAnagram(String first, String second) {
        if (first == null || second == null)
            return false;

        String firstNormalized = first
                .chars()
                .filter(Character::isLetterOrDigit)
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();

        String secondNormalized = second
                .chars()
                .filter(Character::isLetterOrDigit)
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();

        if (firstNormalized.length() != secondNormalized.length())
            return false;

        var firstFrequencies = firstNormalized
                .toLowerCase()
                .chars()
                .boxed()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));

        var secondFrequencies = secondNormalized
                .toLowerCase()
                .chars()
                .boxed()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));

        return firstFrequencies.equals(secondFrequencies);
    }
}
