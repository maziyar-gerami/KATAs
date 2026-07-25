package calculator;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.function.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Calculator {
    public static int sum(int a, int b) {
        IntBinaryOperator summation = Integer::sum;
        return summation.applyAsInt(a, b);
    }

    public static int minus(int a, int b) {
        IntBinaryOperator minus = (a1, b1) -> a1 -b1;
        return minus.applyAsInt(a, b);
    }

    public static boolean isNegative(int i) {
        IntPredicate isNegative =a -> (a < 0);
        return isNegative.test(i);
    }

    public static int plusFive(int i) {
        IntUnaryOperator plus = a -> a + 5;
        return  plus.applyAsInt(i);
    }
}
