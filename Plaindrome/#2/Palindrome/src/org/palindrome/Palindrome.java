package org.palindrome;

public class Palindrome {

    public static boolean calculate(String s){
        return new StringBuilder(s.toLowerCase())
                .reverse().toString().equals(s.toLowerCase());
    }
}
