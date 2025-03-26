class FizzBuzzCalculator {

    public static FizzBuzz calculate(int number) {
        boolean dividableByThree = number % 3 == 0;
        boolean dividableByFive = number % 5 == 0;

        if (dividableByThree && dividableByFive)
            return FizzBuzz.FIZZ_BUZZ;
        else if (dividableByThree)
            return FizzBuzz.FIZZ;
        else if (dividableByFive)
            return FizzBuzz.BUZZ;

        return null;
    }
}
