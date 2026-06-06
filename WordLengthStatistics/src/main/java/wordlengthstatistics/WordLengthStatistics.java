package wordlengthstatistics;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WordLengthStatistics {

    public static Map<Integer, Long> calculate(String text) {
        if (text == null || text.isBlank())
            return Map.of();

        var words = text
                .replaceAll(" +", " ")
                .strip().split(" ");

        return Arrays.stream(words)
                .collect(Collectors.groupingBy(String::length, Collectors.counting()));
    }
}
