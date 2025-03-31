package org.example;

public class StringReversal {

    private final String s;

    public StringReversal(String s) {
        this.s = s;
    }

    public String reverse() {
        return new StringBuilder(s.toLowerCase()).reverse().toString();
    }
}
