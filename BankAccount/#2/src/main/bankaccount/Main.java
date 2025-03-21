package main.bankaccount;

public class Main {
    public static void main(String[] args) {

        Agent banking = new Agent();
        banking.deposit(1000);
        banking.withdraw(500);
        banking.deposit(2000);
        System.out.println(banking.getBalance());
        System.out.println(banking.getTransaction());
    }
}
