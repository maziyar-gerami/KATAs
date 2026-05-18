# Day 1 / 200

## Kata Title
Transaction Analyzer

## Difficulty
Medium

## Estimated Solve Time
20–30 minutes

## Concepts Practiced
- Array/List processing
- Loops
- Basic Collections usage
- Clean method design

---

## Problem Description

You are given a list of bank transaction amounts for a single day.

Each transaction is represented as an integer:

- Positive numbers represent deposits
- Negative numbers represent withdrawals

Your task is to analyze these transactions and produce a summary.

---

## Requirements

Create a method:

    public static TransactionSummary analyzeTransactions(List<Integer> transactions)

The method must compute:

- Total balance change (sum of all transactions)
- Number of deposits
- Number of withdrawals
- Largest deposit
- Largest withdrawal (most negative value)

Create a class:

    class TransactionSummary

With the following fields:

    int totalBalanceChange
    int depositCount
    int withdrawalCount
    int largestDeposit
    int largestWithdrawal

---

## Edge Behavior

- If there are no deposits → largestDeposit = 0
- If there are no withdrawals → largestWithdrawal = 0

---

## Constraints

- Do NOT use Streams yet.
- Use loops and basic collections.
- The list is not null but may be empty.

---

## Example

### Input

    transactions = [100, -20, 50, -10, -70, 200]

### Output

    totalBalanceChange = 250
    depositCount = 3
    withdrawalCount = 3
    largestDeposit = 200
    largestWithdrawal = -70

---

## Hints (Optional)

- Iterate through the list once.
- Track the largest deposit and withdrawal during the loop.
- Initialize values carefully to handle empty lists.

---

## Starter Code
```java
import java.util.*;

class TransactionSummary {
int totalBalanceChange;
int depositCount;
int withdrawalCount;
int largestDeposit;
int largestWithdrawal;

public TransactionSummary(int totalBalanceChange, int depositCount,
int withdrawalCount, int largestDeposit,
int largestWithdrawal) {
this.totalBalanceChange = totalBalanceChange;
this.depositCount = depositCount;
this.withdrawalCount = withdrawalCount;
this.largestDeposit = largestDeposit;
this.largestWithdrawal = largestWithdrawal;
}
}

public class TransactionAnalyzer {

public static TransactionSummary analyzeTransactions(List<Integer> transactions) {
// your implementation here
return null;
}

}
