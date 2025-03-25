public class FizzBuzz {
    public String calculate(int number) {
        if (number % 5 == 0 && number % 3 ==0)
            return "FIZZBUZZ";
        if (number % 3 == 0)
            return "FIZZ";
        if (number % 5 == 0)
            return "BUZZ";

        return String.valueOf(number);
    }
}
