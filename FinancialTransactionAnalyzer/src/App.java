import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import domain.Transaction;
import service.TransactionProcessor;

public class App {
    public static void main(String[] args) throws Exception {
        List<Transaction> transactions = List.of(
                new Transaction(1, LocalDate.of(2023, 10, 1), new BigDecimal("-50.00"), "Food", "Pizza"),
                new Transaction(2, LocalDate.of(2023, 10, 2), new BigDecimal("2000.00"), "Salary", "Monthly Pay"),
                new Transaction(3, LocalDate.of(2023, 10, 5), new BigDecimal("-20.00"), "Food", "Coffee"),
                new Transaction(4, LocalDate.of(2023, 11, 1), new BigDecimal("-100.00"), "Utilities", "Electricity"));

        TransactionProcessor.printCalculateExpenses(transactions);
    }
}
