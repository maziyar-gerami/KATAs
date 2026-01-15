import static java.lang.Math.*;

public class DetectPrimeNumbers {

    public static boolean detector(int input) {
        if (input < 0) throw new IllegalArgumentException();
        if (input < 2) return false;
        double middleOfInput = (int) sqrt(input);
        for (int i = 2; i <= middleOfInput; i++)
            if (input % i == 0) return false;
        return true;
    }
}
