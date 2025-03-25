public class Main{

    public static void main(String[] args){
        Banking bank = new Banking();
        bank.deposit(100);
        bank.deposit(200);
        bank.withdraw(50);
        bank.printStatement();
    }
}