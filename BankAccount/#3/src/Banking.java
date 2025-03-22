import java.time.LocalDateTime;
import java.util.LinkedList;

public class Banking implements FinancialAccount {

    private int balance = 0;
    private final LinkedList<Transaction> transactions = new LinkedList<>();

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public LinkedList<Transaction> getTransactions() {
        return transactions;
    }

    @Override
    public void deposit(int amount) {
        if (amount < 0)
            throw new IllegalArgumentException("Amount must be greater than or equal to zero");
        balance += amount;
        transactions.add(new Transaction(amount, LocalDateTime.now()));
    }

    @Override
    public void withdraw(int amount) {
        if (amount < 0)
            throw new IllegalArgumentException("Amount must be greater than or equal to zero");
        if (amount > balance)
            throw new IllegalArgumentException("Amount must be less than balance");

        balance -= amount;
        transactions.add(new Transaction(-amount, LocalDateTime.now()));
    }

    @Override
    public void printStatement() {

    }
}
