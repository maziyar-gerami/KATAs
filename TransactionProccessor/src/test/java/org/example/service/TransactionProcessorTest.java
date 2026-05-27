package org.example.service;

import org.example.domain.Category;
import org.example.domain.Transaction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;
import java.util.Map;

import static java.util.UUID.randomUUID;
import static org.example.domain.Category.*;
import static org.example.domain.Status.*;
import static org.junit.jupiter.api.Assertions.*;

class TransactionProcessorTest {

    @Test
    void testTransactionProcessor_whenEverythingIsOk_thenFilterOut() {
        var t1 = new Transaction(randomUUID().toString(), 200, ENTERTAINMENT, PENDING);
        var t2 = new Transaction(randomUUID().toString(), 2000, GROCERIES, COMPLETED);
        var t3 = new Transaction(randomUUID().toString(), 200, ENTERTAINMENT, PENDING);
        var t4 = new Transaction(randomUUID().toString(), -400, ENTERTAINMENT, COMPLETED);
        var t5 = new Transaction(randomUUID().toString(), 5000, GROCERIES, COMPLETED);
        var t6 = new Transaction(randomUUID().toString(), 4000, ENTERTAINMENT, COMPLETED);

        var transactions = List.of(t1, t2, t3, t4, t5, t6);
        Map<Category, Double> expectedResult = Map.of(GROCERIES, 7000d, ENTERTAINMENT, 4000d);

        var result = TransactionProcessor.process(transactions);

        assertEquals(expectedResult, result);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void testTransactionProcessor_whenTransactionIsNullOrEmpty_thenFilterOut(List<Transaction> transactions) {
        var expectedResult = Map.of();

        var result = TransactionProcessor.process(transactions);

        assertEquals(expectedResult, result);
    }

    @Test
    void testTransactionProcessor_whenListContainingNullOrRejected_thenFilterOut() {
        var t1 = new Transaction(randomUUID().toString(), 200, ENTERTAINMENT, PENDING);
        var t2 = new Transaction(randomUUID().toString(), 2000, GROCERIES, PENDING);

        var transactions = List.of(t1, t2);
        Map<Category, Double> expectedResult = Map.of();

        var result = TransactionProcessor.process(transactions);

        assertEquals(expectedResult, result);
    }
}