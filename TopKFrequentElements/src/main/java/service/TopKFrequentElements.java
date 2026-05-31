package service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TopKFrequentElements {

    public static List<Integer> findTopK(List<Integer> numbers, int k) {
        if (k < 1)
            return List.of();

        if (numbers == null || numbers.isEmpty())
            return List.of();

        var distinctNumbers = numbers.stream().distinct().toList();
        if (distinctNumbers.size() <= k)
            return distinctNumbers;

        return null;
    }
}
