public class Main {

    public static void main(String[] args) {
        
        System.out.println("Hello world");

        Banking banking = new Banking();
        banking.deposit(1000);
        banking.withdraw(500);
        banking.deposit(2000);
        System.out.println(banking.balance);
        System.out.println(banking.transactions);
    }
}