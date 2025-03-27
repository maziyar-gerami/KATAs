package org.palindrome;

public class Palindrome {
    public static boolean calculate(String s) {
        boolean isEven = s.length() % 2 == 0;
        return isEven ? whenStringIsEven(s) : whenStringIsOdd(s);
    }

    private static boolean whenStringIsOdd(String s) {
        int middle = s.length() / 2;
        String s1 = s.substring(0, middle).toLowerCase();
        String s2 = s.substring(middle + 1).toLowerCase();
        String reversedS2 = new StringBuilder(s2).reverse().toString();
        return s1.equals(reversedS2);
    }

    private static boolean whenStringIsEven(String s) {
        int middle = s.length() / 2;
        String s1 = s.substring(0, middle).toLowerCase();
        String s2 = s.substring(middle).toLowerCase();
        String reversedS2 = new StringBuilder(s2).reverse().toString();
        return s1.equals(reversedS2);
    }
}
