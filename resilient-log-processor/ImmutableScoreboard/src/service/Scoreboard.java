package service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import domain.Player;

public class Scoreboard {

    public List<Player> rankPlayers(ArrayList<Player>  players){
        players.sort(new PlayerComparator());

        return players;
    }

    public static class PlayerComparator implements Comparator<Player>{

@Override
public int compare(Player p1, Player p2) {
    return Comparator
        .comparingInt(Player::getScore).reversed()
        .thenComparing(Comparator.comparingInt(Player::level).reversed())
        .thenComparing(Player::getName)
        .compare(p1, p2);
}
    }
    
}
