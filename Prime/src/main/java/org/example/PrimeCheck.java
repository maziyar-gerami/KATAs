package org.example;

public class PrimeCheck {

    public boolean isPrime(int input) {
        if (input < 2)
            return false;

        double squared = Math.sqrt(input);

        for (int i = 2; i <= squared; i++)
            if (input % i == 0)
                return false;

        return true;
    }
}
