import java.util.LinkedList;

public class TextAnalyze implements Analyzeable {

    private String text;
    private LinkedList<String> history;
    
    public TextAnalyze(String text) {
        this.text = text;
        this.history = new LinkedList<>();
        saveHistory(text);
    }

    @Override
    public long count() {
        saveHistory(Action.COUNT_CHARS.getName());
        saveHistory(text);
        return text.length();
    }

    @Override
    public long words() {
        saveHistory(Action.COUNT_WORDS.getName());
        String[] wordsArray = text.trim().split("\\s+");
        return wordsArray.length;
    }

    @Override
    public String reverse() {
        saveHistory(Action.REVERSE.getName());
        StringBuilder stringBuilder = new StringBuilder(text);
        return stringBuilder.reverse().toString();
    }

    @Override
    public String upercase() {
        saveHistory(Action.UPPERCASE.getName());
        return text.toUpperCase();
    }

    @Override
    public String lowercase() {
        saveHistory(Action.LOWERCASE.getName());
        return text.toLowerCase();
    }

    @Override
    public void stats() {
        history.stream().
            forEach(i -> System.out.println(i));
    }

    @Override
    public void saveHistory(String str) {
        history.add(str);
    }
    
}
