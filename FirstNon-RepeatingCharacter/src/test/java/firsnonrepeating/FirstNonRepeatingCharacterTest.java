package firsnonrepeating;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Optional;
import java.util.stream.Stream;

class FirstNonRepeatingCharacterTest {

    public static Stream<Arguments> validSourceProvider() {
        return Stream.of(Arguments.of("swiss", "w"),
                Arguments.of(" s wiss ", "w")
                );
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "        "})
    void firstNonRepeatingCharacter_whenInputIsNullOrEmpty_thenReturnOptionalEmpty(String input){
        var result = FirstNonRepeatingCharacter.find(input);
        Assertions.assertEquals(Optional.empty(), result);
    }

    @ParameterizedTest
    @MethodSource(value = "validSourceProvider")
    void firstNonRepeatingCharacter_whenInputIsCorrect_thenReturnFirstNonRepeatingCharacter(String input, Character expectedChar){
        var result = FirstNonRepeatingCharacter.find(input);
        Assertions.assertEquals(Optional.of(expectedChar), result);
    }


}