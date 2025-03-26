public class Main {
    public static void main(String[] args) {
        int n = 3;
        print(n);

        n = 5;
        print(n);

        n = 15;
        print(n);

        n = 8;
        print(n);

    }

    private static void print(int number){
        var result = FizzBuzzCalculator.calculate(number);
        System.out.println(result == null ? number : result);
    }
}