import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class Banking implements FinancialAccount {

    private int balance = 0;
    private List<Transaction> transactions = new LinkedList<>();

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setTransactions(List<Transaction> transactions){
        this.transactions = transactions;
    }

    public List<Transaction> getTransactions() {
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
        System.out.println("Balance: " + balance);
        System.out.println("*********************");
        System.out.println(transactions.toString());
    }
}
