import java.util.LinkedList;
import java.time.LocalDateTime;

public class Banking implements BankAcount {

    LinkedList<Record> transactions = new LinkedList<>();
    int balance = 0;

    @Override
    public void deposit(int amount) {
        if (amount <= 0)
            throw new UnsupportedOperationException("Money should be positive");

        transactions.add(new Record(amount, LocalDateTime.now()));
        balance += amount;
    }

    @Override
    public void withdraw(int amount) {
        if (amount <= 0)
            throw new UnsupportedOperationException("Money should be positive");

        transactions.add(new Record(-amount, LocalDateTime.now()));
        balance -= amount;
    }

    @Override
    public void printStatement() {
        for (Record record : transactions) {
            System.out.println(record.toString());
        }
    }
}