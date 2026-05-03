import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello to text analyzer!");
        try(Scanner scanner = new Scanner(System.in)) {
            System.out.println("Please enter a text:");
            String text = scanner.nextLine();
            TextAnalyze textAnalyze = new TextAnalyze(text);
            long x = textAnalyze.count();
            System.out.println("Number of characters: " + x);
            System.out.println("Number of words: " + textAnalyze.words());
            System.out.println("Reversed text: " + textAnalyze.reverse());
            System.out.println("Uppercase text: " + textAnalyze.upercase());
            System.out.println("Lowercase text: " + textAnalyze.lowercase());
            System.out.println("History: ");
            textAnalyze.stats();
        }
    }
}
