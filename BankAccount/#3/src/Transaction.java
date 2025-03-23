import java.time.LocalDateTime;

public class Transaction {

    private final int amount;
    private final LocalDateTime date;

    public int getAmount(){
        return this.amount;
    }

    public LocalDateTime getDate(){
        return this.date;
    }

    public Transaction(int amount, LocalDateTime date) {
        this.amount = amount;
        this.date = date;
    }

    @Override
    public String toString() {
        return "amount=" + amount +
                ", date=" + date + "\n";
    }
}
