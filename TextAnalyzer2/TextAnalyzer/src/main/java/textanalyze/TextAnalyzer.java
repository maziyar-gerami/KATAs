package textanalyze;

import com.sun.tools.javac.Main;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.awt.SystemColor.text;

public class TextAnalyzer {

    public static void main(String[] args) throws IOException {
/*        String fileName = "sample.tex";
        String fileContent = readFile(fileName);
        var words = fileContent.split(" +");
        var wordCount = words.length;
        var charCount = Arrays.stream(words)
                .mapToInt(String::length)
                .sum();*/

        List<Integer> integers = List.of(10, 20, 30, 40, 50);
        int sum = integers.stream()
                .reduce(1000, Integer::sum);
        System.out.println(sum);

        var x = integers.stream()
                .collect(Collectors.groupingBy(Integer::bitCount));

        System.out.println(x);
    }

    private static String readFile(String fileName) throws IOException {
        try (InputStream inputStream = Main.class.getResourceAsStream(fileName)) {
            if (inputStream == null)
                throw new IllegalArgumentException("File is empty");

            return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        }
    }
}
