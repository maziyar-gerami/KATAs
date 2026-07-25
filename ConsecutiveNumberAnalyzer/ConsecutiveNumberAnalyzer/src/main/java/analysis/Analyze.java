package analysis;

import java.util.List;
import java.util.stream.IntStream;

public class Analyze {

    AnalysisResult analyze(List<Integer> numbers, int threshold) {
        long count = IntStream.range(0, numbers.size() - 1)
                .filter(i -> Math.abs(numbers.get(i) - numbers.get(i + 1)) <= threshold)
                .count();

        int maxDifference = IntStream.range(0, numbers.size() - 1)
                .map(i -> Math.abs(numbers.get(i) - numbers.get(i + 1)))
                .max()
                .orElse(0);

        return new AnalysisResult((int) count, maxDifference);
    }

}
