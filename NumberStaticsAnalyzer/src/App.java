import java.util.Scanner;

public class App {

    static Calculation calc = new Calculation();
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)){
            terminal(scanner.nextLine());
            
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    private static void terminal(String command){
        int splitIndex = command.indexOf(' ');
        String cmd = command.substring(0, splitIndex);
        String numStr = command.substring(splitIndex+1);

        double num = Double.parseDouble(numStr);

        switch (cmd.toUpperCase()) {
            case "ADD" -> calc.add(num);
            case "MINUS" -> calc.minus(num);
            default -> throw new IllegalStateException("Incorrect");
        }

    }
}
