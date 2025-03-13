import java.time.LocalDateTime;

public class Record {

    private int amount;
    private LocalDateTime date;

    public Record(int amount, LocalDateTime now) {
        this.amount = amount;
        this.date = now;

    }

    @Override
    public String toString() {
        return String.valueOf(amount) +" , "+ date.toString() +"\n";
    }
}
