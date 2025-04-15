package org.example;

public class PrimeCheck {

    public boolean isPrime(int input) {

        double squared = Math.sqrt(input);

        if (input < 2)
            return false;

        for (int i = 2; i <= squared; i++)
            if (input % i == 0)
                return false;

        return true;
    }
}
