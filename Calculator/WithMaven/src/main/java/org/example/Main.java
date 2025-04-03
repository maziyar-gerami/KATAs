package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String operand;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter operand");
        operand = scanner.next();
        System.out.println("Enter first number: ");
        double a = scanner.nextDouble();
        System.out.println("Enter second number: ");
        double b = scanner.nextDouble();
        Calculator calculator = new Calculator(a, b);
        String result = switch (operand) {
            case "+" -> String.valueOf(calculator.sum());
            case "-" -> String.valueOf(calculator.minus());
            case "/" -> String.valueOf(calculator.divide());
            case "*" -> String.valueOf(calculator.multiply());
            default -> "Invalid";
        };
        System.out.println(result);
    }
}