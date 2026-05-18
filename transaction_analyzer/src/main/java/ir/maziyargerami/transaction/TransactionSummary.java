package ir.maziyargerami.transaction;

import java.util.List;

public class TransactionSummary {

    private final int totalBalanceChange;
    private final int depositCount;
    private final int withdrawalCount;
    private final int largestDeposit;
    private final int largestWithdrawal;

    private TransactionSummary(int totalBalanceChange, int depositCount, int withdrawalCount, int largestDeposit, int largestWithdrawal) {
        this.totalBalanceChange = totalBalanceChange;
        this.depositCount = depositCount;
        this.withdrawalCount = withdrawalCount;
        this.largestDeposit = largestDeposit;
        this.largestWithdrawal = largestWithdrawal;
    }

    public static TransactionSummary analyzeTransactions(List<Integer> transactions){
        return new TransactionSummary(computeTotalBalanceChange(transactions), computeDepositCount(transactions), computeWithdrawalCount(transactions), computeLargestDeposit(transactions), computeLargestWithdrawal(transactions));

    }

    private static int computeTotalBalanceChange(List<Integer> transactions){
        int total = 0;
        for (Integer transaction : transactions) 
            total += transaction;
        return total;
    }

    private static int computeDepositCount(List<Integer> transactions){
        int count = 0;
        for (Integer transaction : transactions) 
            if (transaction > 0) count++;
        return count;
    }

    private static int computeWithdrawalCount(List<Integer> transactions){
        int count = 0;
        for (Integer transaction : transactions) 
            if (transaction < 0) count++;
        return count;
    }

    private static int computeLargestDeposit(List<Integer> transactions){
        int largest = 0;
        for (Integer transaction : transactions) 
            if (transaction > largest) largest = transaction;
        return largest;
    }

    private static int computeLargestWithdrawal(List<Integer> transactions){
        int largest = 0;
        for (Integer transaction : transactions) 
            if (transaction < largest) largest = transaction;
        return largest;
    }

    @Override
    public String toString() {
        return "TransactionSummary{" +
                "totalBalanceChange=" + totalBalanceChange +
                ", depositCount=" + depositCount +
                ", withdrawalCount=" + withdrawalCount +
                ", largestDeposit=" + largestDeposit +
                ", largestWithdrawal=" + largestWithdrawal +
                '}';
    }    

}
