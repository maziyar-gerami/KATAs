package org.example;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CharacterFrequencyCounter {

    public static Map<Character, Integer> countCharacters(String str) {
        if (str == null || str.isBlank())
            return new LinkedHashMap<>();

        return str
                .chars()
                .mapToObj(c -> (char) c)
                .filter(c -> !Character.isWhitespace(c))
                .collect(Collectors.toMap(
                        Function.identity(),
                        c -> 1,
                        Integer::sum,
                        LinkedHashMap::new
                ));
    }
}
