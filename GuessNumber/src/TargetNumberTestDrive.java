import java.io.IOException;
import java.util.Scanner;

public class TargetNumberTestDrive {

    public static void main(String[] args) throws IOException {
        TargetNumber targetNumber = new TargetNumber();

        try (Scanner scanner = new Scanner(System.in)) {

            while (true) {
                int number = scanner.nextInt();
                targetNumber.guess(number);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
