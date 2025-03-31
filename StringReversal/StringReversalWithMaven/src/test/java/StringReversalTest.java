import org.example.StringReversal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringReversalTest {

    @Test
    void testStringReverse() {
        String s = "Java";
        String result = new StringReversal(s).reverse();

        assertEquals("avaj", result);
    }
}
