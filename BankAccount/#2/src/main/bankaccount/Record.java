package main.bankaccount;

import java.time.LocalDateTime;

public class Record {

    int amount;

    LocalDateTime date;

    public Record(int amount, LocalDateTime date){
        this.amount = amount;
        this.date = date;
    }

    @Override
    public String toString() {
        return amount + "    ,      " + date + "\n";
    }
}
