package core.fizzbuzz;

public class PlayFizzBuzz {

    enum FizzBuzz {
        FIZZ,
        BUZZ,
        FIZZ_BUZZ
    }

    public static void play(int number) {
        var dividableByThree = number % 3 == 0;
        var dividableByFive = number % 5 == 0;

        if (dividableByThree && dividableByFive)
            System.out.print(FizzBuzz.FIZZ_BUZZ);
        else if (dividableByThree)
            System.out.print(FizzBuzz.FIZZ);
        else if (dividableByFive)
            System.out.print(FizzBuzz.BUZZ);
        else
            System.out.print(number);
    }
}
