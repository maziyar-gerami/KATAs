package domain;

public class Player{
    
    private final String name;

    private final int score;

    private final int level;

    public Player(String name, int score, int level){
        if (score < 0) 
            throw new IllegalArgumentException("Score should be a positive number");

        if (level < 1) 
            throw new IllegalArgumentException("Level should be equal or more than one");

        this.name = name;
        this.score = score;
        this.level = level;
    }

    public String getName(){
        return name;
    }

    public int getScore(){
        return score;
    }

    public int level(){
        return level;
    }
}