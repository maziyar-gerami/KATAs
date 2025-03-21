package bankaccount;

import main.bankaccount.Agent;

public class MainTest {

    private final static Agent agent = new Agent();

    public static void main(String[] args) {

        testBanking_deposit();
        testBanking_withdraw();

        System.out.println("Test Finished!");
    }

    private static void testBanking_deposit() {
        if (agent.getBalance() != 0)
            System.out.println("First point is incorrect");

        agent.deposit(100);

        if (agent.getBalance() != 100)
            System.out.println("Deposition is not correct");

        if (agent.getTransaction().size() == 0)
            System.out.println("Deposition is not correct");

    }

    private static void testBanking_withdraw() {
        agent.setBalance(0);
        agent.deposit(100);
        agent.withdraw(100);

        if (agent.getBalance() != 0){
            System.out.println(agent.getBalance());
            System.out.println("Withdraw is not correct : Balance");}

        if (agent.getTransaction().size() == 2)
            System.out.println("Withdraw is not correct: Transactions");
    }
}