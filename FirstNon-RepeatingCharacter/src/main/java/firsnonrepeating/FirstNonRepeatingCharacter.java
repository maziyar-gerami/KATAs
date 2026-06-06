package firsnonrepeating;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatingCharacter {

    public static Optional<Character> find(String text) {
        if (text == null)
            return Optional.empty();

        var truncatedText = text.strip();
        if (truncatedText.isEmpty())
            return Optional.empty();

        var originalTruncatedInput = text.replaceAll("\\s", "");
        var loweredTruncatedInput = originalTruncatedInput.toLowerCase();



        loweredTruncatedInput
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .findFirst()
                .map(Map.Entry::getKey)
                .map(i -> (char) i.intValue());
    }
}
