import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello to text analyzer!");
        String statement;
        try(Scanner scanner = new Scanner(System.in)) {
            do{
                System.out.println("Please enter a text:");
                statement = scanner.nextLine();
                TextAnalyze textAnalyze = new TextAnalyze();
                AnayzeHelper command = new AnayzeHelper(statement, textAnalyze);
                command.execute();
            }while(!statement.equalsIgnoreCase("exit"));
        }
    }
}
