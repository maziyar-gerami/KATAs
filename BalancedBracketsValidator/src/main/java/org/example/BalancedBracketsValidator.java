package org.example;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BalancedBracketsValidator {

    private static ArrayDeque<Character> stack = new ArrayDeque<>();
    private static final HashMap<Character, Character> validMarks = new HashMap<>(Map.of('(', ')', '[', ']', '{', '}'));

    public static boolean isValid(String str) {
        if (str == null) return true;
        var cleanedStr = str.replaceAll("[^()\\[\\]{}]", "");
        if (cleanedStr.isEmpty()) return true;

        return validator(cleanedStr);
    }

    private static boolean validator(String str) {
        var opens = validMarks.keySet();

        for (int i = 0; i < str.length(); i++) {
            var tempChar = str.charAt(i);
            if (opens.contains(tempChar)) stack.push(str.charAt(i));
            else if (validMarks.get(stack.pop()) != tempChar) return false;
        }
        return stack.isEmpty();
    }
}
