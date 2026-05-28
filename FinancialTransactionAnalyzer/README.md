# Day 2 / 200: Financial Transaction Analyzer

### Difficulty: Medium
**Estimated Solve Time:** 25–30 minutes

---

### Concepts Practiced
- Java Streams API (`filter`, `map`, `collect`)
- `Collectors.groupingBy` and `Collectors.reducing`
- `java.math.BigDecimal` (Precision arithmetic)
- `java.time.LocalDate`
- Clean Code (Data Encapsulation)

---

### Problem Description
You are building a personal finance tracker. You are given a list of `Transaction` objects. Your task is to process these transactions to generate a summary report.

Each `Transaction` has:
- `id` (long)
- `date` (LocalDate)
- `amount` (BigDecimal) - *Positive for income, negative for expenses.*
- `category` (String)
- `description` (String)

### Requirements
Implement a class `TransactionProcessor` with methods to:
1. **Calculate Total Balance:** Sum of all transaction amounts.
2. **Filter by Month:** Get all transactions that occurred in a specific month and year.
3. **Category Expenses:** Find the total amount spent (negative values) per category. Return this as a `Map<String, BigDecimal>`.
4. **Highest Expense:** Find the single transaction with the most negative value.

### Constraints
- Do **not** use `double` or `float` for the amounts.
- If the list is empty, `calculateTotalBalance` should return `BigDecimal.ZERO`.
- Use the Java Stream API for all processing logic.
- The `Transaction` class should be immutable.

### Example Input / Output
**Input:**
- Transaction(1, 2023-10-01, -50.00, "Food", "Pizza")
- Transaction(2, 2023-10-02, 2000.00, "Salary", "Monthly Pay")
- Transaction(3, 2023-10-05, -20.00, "Food", "Coffee")
- Transaction(4, 2023-11-01, -100.00, "Utilities", "Electricity")

**Expected Output for Category Expenses:**
- "Food": -70.00
- "Utilities": -100.00
*(Salary is ignored in expenses because it is positive)*

---

### Starter Code
```java
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

class Transaction {
private final long id;
private final LocalDate date;
private final BigDecimal amount;
private final String category;
private final String description;

public Transaction(long id, LocalDate date, BigDecimal amount, String category, String description) {
this.id = id;
this.date = date;
this.amount = amount;
this.category = category;
this.description = description;
}

// Getters...
}

public class TransactionProcessor {
public BigDecimal calculateTotalBalance(List<Transaction> transactions) {
// TODO: Implementation
return null;
}

public Map<String, BigDecimal> getExpensesByCategory(List<Transaction> transactions) {
// TODO: Implementation
return null;
}

// Add other methods as per requirements...
}
