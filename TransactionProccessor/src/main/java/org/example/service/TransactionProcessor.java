package org.example.service;

import org.example.domain.Category;
import org.example.domain.Status;
import org.example.domain.Transaction;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TransactionProcessor {

    public static Map<Category, Double> process(List<Transaction> transactions) {

        if (transactions == null || transactions.isEmpty())
            return Map.of();

        Predicate<Transaction> predicate = (t) -> t != null && t.status() == Status.COMPLETED && t.amount() > 0;
        return transactions.stream()
                .filter(predicate)
                .collect(Collectors.groupingBy(Transaction::category, Collectors.summingDouble(Transaction::amount)));
    }
}
