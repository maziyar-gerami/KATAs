public class TargetNumber {
    
    int randomNumber;
    int quessCount;
    private final static int maxCount = 10;

    TargetNumber(){
        randomNumber = (int) (Math.random() * 100);
        quessCount = 0;
    }

    void guess(int number){
        quessCount++;
        System.out.println("Guess count is: " + quessCount);
        if (isGameOver()) 
            throw new IllegalStateException("GameOver! You have used all your tries.");
        
        if (number > randomNumber)
            System.out.println("Too high");
        else if (number < randomNumber)
            System.out.println("Too low");
        else
            System.out.println("Congratulations! You guessed the number in " + quessCount + " tries.");
    }

    boolean isGameOver(){
        return quessCount >= maxCount;
    }
}
