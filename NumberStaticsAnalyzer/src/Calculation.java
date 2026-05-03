import java.util.LinkedHashMap;
import java.util.LinkedList;

public class Calculation implements Calculatable {

    LinkedHashMap<String, Integer> history = new LinkedList<>();
    int currentNumber;

    @Override
    public void add (double num) {
        addToHistory(Actions.ADD, num)
        currentNumber += num;
    }

    @Override
    public void divide (double num) {
        addToHistory(Actions.DIVIDE, num)
        currentNumber /= num;
    }

    @Override
    public void minus(double num) {
                addToHistory(Actions.MINUS, num)
        currentNumber -= num;
    }

    @Override
    public void multiply(double num) {
        addToHistory(Actions.MULTIPLY, num)
        currentNumber *= num;
    }

    @Override
    public void addToHistory(String action, Number num) {
        history.put(action, num)
    }
}
