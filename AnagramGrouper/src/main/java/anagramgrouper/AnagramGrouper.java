package anagramgrouper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AnagramGrouper {

    public static List<List<String>> group(List<String> words) {
        if (words == null || words.isEmpty())
            return List.of();

        Map<String, ArrayList<String>> result = new HashMap<>();

        for (String word : words) {
            char[] chars = word.toLowerCase().toCharArray();
            Arrays.sort(chars);
            String processedWord = new String(chars);

            List<String> groupedWords = result.get(processedWord);
            if (groupedWords == null)
                result.put(processedWord, new ArrayList<>(List.of(word)));
            else
                groupedWords.add(word);
        }

        return result.values()
                .stream()
                .map(list -> (List<String>) list)
                .toList();
    }
}
