import org.example.Main;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BubbleSortTest {

    @Test
    void testBubbleSort(){
        var integers = new ArrayList<>(List.of(3,1,5,2,0));
        var expectedResult = integers.stream().sorted().toList();

        Main main = new Main(integers);

        var result = main.bubbleSort();

        assertEquals(expectedResult, result);
    }
}
