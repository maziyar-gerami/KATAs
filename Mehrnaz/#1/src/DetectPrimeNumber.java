public class DetectPrimeNumber {
    public static boolean detect(int input) {
        //Handle exceptions
        if (input < 2) {
            return false;
        }
        // Find prime number bigger than 1
        for (int i = 2; i < input; i++) {
            if (input % i == 0) {
                return false;
            }
        }
        return true;
    }
}