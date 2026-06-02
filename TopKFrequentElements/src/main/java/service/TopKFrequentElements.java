package service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TopKFrequentElements {

    public static List<Integer> findTopK(List<Integer> numbers, int k) {
        if (k < 1)
            return List.of();

        if (numbers == null || numbers.isEmpty())
            return List.of();

        var distinctNumbers = numbers.stream().distinct().toList();
        if (distinctNumbers.size() == numbers.size())
            return numbers
                    .stream()
                    .sorted()
                    .limit(k).toList();

        return numbers.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(new ListComparator())
                .limit(k)
                .map(Map.Entry::getKey)
                .toList();
    }

    static class ListComparator implements Comparator<Map.Entry<Integer, Long>> {


        @Override
        public int compare(Map.Entry<Integer, Long> t1, Map.Entry<Integer, Long> t2) {

            return Map.Entry.<Integer, Long>comparingByValue()
                    .reversed()
                    .thenComparing(Map.Entry::getKey)
                    .compare(t1, t2);
        }
    }
}
