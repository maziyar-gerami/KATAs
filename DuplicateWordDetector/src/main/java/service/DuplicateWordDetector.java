package service;

import lombok.NoArgsConstructor;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@NoArgsConstructor
public class DuplicateWordDetector {

    public static List<String> findDuplicates(String text) {
        if (text == null || text.isBlank())
            return List.of();

        var textWithoutMark = text.replaceAll("\\p{Punct}", " ");
        var words = textWithoutMark.split(" ");
        return Arrays.stream(words)
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();
    }
}
