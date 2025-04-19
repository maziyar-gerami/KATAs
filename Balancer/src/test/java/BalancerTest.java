import org.example.Balancer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BalancerTest {
    @Test
    void testIsBalance_When_Input_Is_Balance() {
        String input = "()";

        boolean res = Balancer.isBalance(input);

        assertTrue(res);
    }

    @Test
    void testIsBalance_When_Input_Is_Balance2() {
        String input = "([])";

        boolean res = Balancer.isBalance(input);

        assertTrue(res);
    }

    @Test
    void testIsBalance_When_Input_Not_Balance() {
        String input = "([)]";

        boolean res = Balancer.isBalance(input);

        assertFalse(res);
    }

    @Test
    void testIsBalance_When_Input_Is_Balance3() {
        String input = "{[()]}";

        boolean res = Balancer.isBalance(input);

        assertTrue(res);
    }

    @Test
    void testIsBalance_When_Input_Not_Balance2() {
        String input = "((())";

        boolean res = Balancer.isBalance(input);

        assertFalse(res);
    }
}
