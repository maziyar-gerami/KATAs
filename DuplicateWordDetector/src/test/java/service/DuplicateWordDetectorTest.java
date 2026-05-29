package service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class DuplicateWordDetectorTest {

    @Test
    void duplicateWordDetector_whenEverythingIsOk_countWords(){
        String str = "Java, is great! and java is powerful!";
        Set<String> expectedResult = Set.of("java", "is");

        var result = DuplicateWordDetector.findDuplicates(str);

        assertEquals(expectedResult, result);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void duplicateWordDetector_whenTextIsEmpty_returnSetEmptySet(String text){

        var result = DuplicateWordDetector.findDuplicates(text);

        assertEquals(Set.of(), result);
    }

}