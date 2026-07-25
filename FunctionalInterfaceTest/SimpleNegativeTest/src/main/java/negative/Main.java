package negative;

public class Main {

    public static void main(String[] args) {

        Validate validation = i -> i > 0;

        var result = validation.test(10);
        var result1 = validation.test(0);

        System.out.println(result + " " + result1);
    }
}
