package service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import domain.Transaction;

public class TransactionProcessor {
    BigDecimal totalBalance;
    BigDecimal categoryExpenses;
    BigDecimal highestExpense;

    public static void printCalculateExpenses(List<Transaction> transactions) {
        System.out.println("Total Balance: " + calculateTotalBalance(transactions));
        System.out.println("Filter by month: " + calculateCategoryExpenses(transactions, "January"));
        //System.out.println("Category Expenses: " + calculateExpensesByCategory(transactions));
        System.out.println("Highest Expense: " + findHighestExpense(transactions));
    }

    private static BigDecimal calculateTotalBalance(List<Transaction> transactions) {
        if (transactions == null || transactions.isEmpty())
            return BigDecimal.ZERO;
        
        return transactions.stream()
                .map(Transaction::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
}

private static BigDecimal calculateExpensesByCategory(List<Transaction> transactions) {
        if (transactions == null || transactions.isEmpty())
            return BigDecimal.ZERO;

        return transactions.stream()
                .filter(t -> t.getAmount().compareTo(BigDecimal.ZERO) < 0)
                .collect(Collectors.groupingBy(Transaction::getCategory, Collectors.mapping(Transaction::getAmount, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))));
    }

    private static BigDecimal findHighestExpense(List<Transaction> transactions) {
        if (transactions == null || transactions.isEmpty())
            return BigDecimal.ZERO;

        return transactions.stream()
                .map(Transaction::getAmount)
                .filter(amount -> amount.compareTo(BigDecimal.ZERO) < 0) // Only expenses
                .min(BigDecimal::compareTo)
                .orElse(BigDecimal.ZERO);
    }
}
