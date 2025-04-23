public class DetectPrimeNumbersbyTDD {

    public static boolean detector(int i) {
        if (input < 2) return false;
        double middleOfInput = (int) sqrt(input);
        for (int i = 2; i <= middleOfInput; i++)
            if (input % i == 0)
                return false;
        return true;
    }
}
