package ir.maziyargerami;

import java.util.List;

import ir.maziyargerami.transaction.TransactionSummary;

public class Main {
    public static void main(String[] args) {
        TransactionSummary summary = TransactionSummary.analyzeTransactions(List.of(100, -50, 200, -30, 150));
        System.out.println("Total Balance Change: " + summary.toString());
    }
}