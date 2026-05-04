public class AnayzeHelper {
    
    private String statement;
    private String command;
    private String arguement;
    private TextAnalyze textAnalyze;

    public AnayzeHelper(String statement, TextAnalyze textAnalyze) {
        this.statement = statement;
        this.textAnalyze = textAnalyze;
    }

    private void parse(){
        this.command = statement.split(" ")[0];
        if (!command.equals(Action.STATS.getName().toUpperCase()))
            try {
                this.arguement = statement.split(" ")[1];
            } catch (Exception e) {
                throw new IllegalArgumentException("Insufficient arguments for command: " + command);
            }
        textAnalyze.setText(arguement);
    }

    void execute() {
        System.out.println("Executing command: " + command);
        parse();
        var action = Action.DEFAULT;
        try {
            action = Action.valueOf(command.toUpperCase());
        } catch (Exception e) {
            return;
        }
        switch (action) {
            case COUNT_CHARS -> textAnalyze.count();
            case COUNT_WORDS -> textAnalyze.words();
            case LOWERCASE -> textAnalyze.lowercase();
            case REVERSE -> textAnalyze.reverse();
            case UPPERCASE -> textAnalyze.upercase();
            case STATS -> textAnalyze.stats();
            case DEFAULT -> throw new IllegalArgumentException("Unexpected value: " + action);
            default -> throw new IllegalArgumentException("Unexpected value: " + action);
        }
    }
}
