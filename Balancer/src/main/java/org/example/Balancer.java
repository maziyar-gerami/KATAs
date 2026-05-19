package org.example;

import java.util.Stack;

public class Balancer {

    public static boolean isBalance(String input) {
        Stack<Character> charStack = new Stack<>();
        if (input.isEmpty())
            return false;

        for (int i = 0; i <= input.length() - 1; i++) {
            char temp = input.charAt(i);

            if (temp == '(' || temp == '[' || temp == '{')
                charStack.push(temp);
            else {
                if (charStack.isEmpty() ||
                        (temp == ')') && (charStack.pop() != '(') ||
                        (temp == '}') && (charStack.pop() != '{') ||
                        (temp == ']') && (charStack.pop() != '[')) {
                    return false;
                }
            }
        }

        return charStack.isEmpty();
    }
}
