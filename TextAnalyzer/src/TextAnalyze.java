import java.util.LinkedList;

public class TextAnalyze implements Analyzeable {

    private String text;
    private LinkedList<String> history;

    public void setText(String text) {
        this.text = text;
    }

    
    
    public TextAnalyze() {
        this.history = new LinkedList<>();
    }


    public TextAnalyze(String text) {
        this.text = text;
        this.history = new LinkedList<>();
    }

    @Override
    public void count() {
        saveHistory(Action.COUNT_CHARS.getName());
        System.out.println(text.length());
    }

    @Override
    public void words() {
        saveHistory(Action.COUNT_WORDS.getName());
        String[] wordsArray = text.trim().split("\\s+");
        System.out.println(wordsArray.length);
    }

    @Override
    public void reverse() {
        saveHistory(Action.REVERSE.getName());
        StringBuilder stringBuilder = new StringBuilder(text);
        System.out.println(stringBuilder.reverse().toString());
    }

    @Override
    public void upercase() {
        saveHistory(Action.UPPERCASE.getName());
        System.out.println(text.toUpperCase());
    }

    @Override
    public void lowercase() {
        saveHistory(Action.LOWERCASE.getName());
        System.out.println(text.toLowerCase());
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
