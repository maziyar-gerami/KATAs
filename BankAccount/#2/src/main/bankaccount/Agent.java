package main.bankaccount;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Agent implements FinancialAccount {

    private int balance = 0;
    private LinkedList<Record> transactions = new LinkedList<>();

    public int getBalance(){
        return balance;
    }

    public void setBalance(int balance){
        this.balance = balance;
    }

    public LinkedList<Record> getTransaction(){
        return transactions;
    }

    public boolean isEnough(int amount){
        if (this.balance < amount) 
             return false;
        return true;
    }

    @Override
    public void deposit(int amount) {
        if(amount<= 0)
            throw new UnsupportedOperationException("Money should positive");

        balance += amount;

        Record record = new Record(amount, LocalDateTime.now());
        transactions.add(record);
    }

    @Override
    public void withdraw(int amount) {
        if(amount < 0 || !isEnough(amount))
            throw new UnsupportedOperationException("Money should positive");
        
        balance -= amount;
        Record record = new Record(-amount, LocalDateTime.now());
        transactions.add(record);
    }

    @Override
    public void printStatement() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'printStatement'");
    }
    
}
