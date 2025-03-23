import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class BankingTest {

    @Test
    void depositTest_negativeAmount() {
        int amount = -10;
        Banking bank = new Banking();
        var throwable = assertThrows(IllegalArgumentException.class, () -> bank.deposit(amount));
        assertNotNull(throwable.getMessage());
    }

    @Test
    void depositTest_recordAdded() {
        int amount = 10;
        Banking bank = new Banking();

        int before = bank.getBalance();
        bank.deposit(amount);
        int after = bank.getBalance();

        assertEquals(0, before);
        assertEquals(10, after);
        assertEquals(1, bank.getTransactions().size());
        assertEquals(amount, bank.getTransactions().getFirst().getAmount());
        assertNotNull(bank.getTransactions().getFirst().getDate());
    }

    @Test
    void withdrawTest_negativeAmount() {
        int amount = -10;
        Banking bank = new Banking();

        var throwable = assertThrows(IllegalArgumentException.class, () -> bank.withdraw(amount));
        assertNotNull(throwable.getMessage());
    }

    @Test
    void withdrawTest_balanceNotEnough() {
        int amount = 10;
        Banking bank = new Banking();
        int before = bank.getBalance();
        var throwable = assertThrows(IllegalArgumentException.class, () -> bank.withdraw(amount));
        int after = bank.getBalance();
        assertNotNull(throwable.getMessage());
        assertEquals(before, after);
    }

    @Test
    void withdrawTest_balanceEnough() {
        int balance = 100;
        int amount = 10;
        Banking bank = new Banking();
        bank.setBalance(balance);
        int before = bank.getBalance();
        bank.withdraw(amount);
        int after = bank.getBalance();
        assertEquals(before-amount, after);

        assertEquals(1, bank.getTransactions().size());
        assertEquals(-amount, bank.getTransactions().getFirst().getAmount());
        assertNotNull(bank.getTransactions().getFirst().getDate());
    }

    @Test
    void printStatement_successfully(){
        LinkedList<Transaction> transactions = new LinkedList<>();
        transactions.add(new Transaction(10, LocalDateTime.MIN));
        transactions.add(new Transaction(20, LocalDateTime.MAX));

        Banking bank = new Banking();
        bank.setTransactions(transactions);

        assertDoesNotThrow(bank::printStatement);
    }
}