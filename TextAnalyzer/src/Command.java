public class Command {
    
    private String statement;
    private String command;
    private String arguement;
    private TextAnalyze textAnalyze;

    public Command(String statement, TextAnalyze textAnalyze) {
        this.statement = statement;
        this.command = statement.split(" ")[0];
        this.arguement = statement.split(" ")[1];
        textAnalyze.setText(this.arguement);
        this.textAnalyze = textAnalyze;
    }

    void execute() {
        System.out.println("Executing command: " + command);
        Action action = Action.valueOf(command.toUpperCase());
        switch (action) {
            case COUNT_CHARS -> textAnalyze.count();
            case COUNT_WORDS -> textAnalyze.words();
            case LOWERCASE -> textAnalyze.lowercase();
            case REVERSE -> textAnalyze.reverse();
            case UPPERCASE -> textAnalyze.upercase();
            default -> throw new IllegalArgumentException("Unexpected value: " + action);
        }
    }
}
