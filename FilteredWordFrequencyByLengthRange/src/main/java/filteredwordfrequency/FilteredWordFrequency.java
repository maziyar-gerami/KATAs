package filteredwordfrequency;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FilteredWordFrequency {

    public static Map<Integer, Long> calculate(String text, int minLength, int maxLength) {
        if (!validate(text, minLength, maxLength))
            return Map.of();

        return Arrays.stream(text
                        .strip()
                        .split("\\s+"))
                .filter(e -> e.length() >= minLength && e.length() <= maxLength)
                .collect(Collectors.groupingBy(String::length, Collectors.counting()));
    }

    private static boolean validate(String text, int minLength, int maxLength) {
        return text != null && !text.isBlank() && minLength > 0 && maxLength >= minLength;
    }
}
