package org.example;

import java.util.List;

public class Main {

    private static List<Integer> integers;

    public Main(List<Integer> integers) {
        Main.integers = integers;
    }

    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }

    public List<Integer> bubbleSort() {
        for (int i = 0; i < integers.size() - 1; i++)
            for (int j = i + 1; j < integers.size(); j++)
                if (integers.get(i) > integers.get(j))
                    swapIndexes(i, j);

        return integers;
    }

    private static void swapIndexes(int i, int j) {
        int iValue = integers.get(i);
        int jValue = integers.get(j);
        integers.set(i, jValue);
        integers.set(j, iValue);
    }
}