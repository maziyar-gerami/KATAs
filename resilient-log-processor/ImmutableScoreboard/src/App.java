import java.util.ArrayList;

import domain.Player;
import service.Scoreboard;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Player p1 = new Player("Alice", 100, 5);
        Player p2 = new Player("Bob", 150, 3);
        Player p3 = new Player("Charlie", 100, 5);
        var players = new ArrayList<Player>();
        players.add(p1);
        players.add(p2);
        players.add(p3);

        Scoreboard scoreboard = new Scoreboard();

        var rankedPlayers = scoreboard.rankPlayers(players);

        rankedPlayers.forEach(player -> System.out.println(player.getName()));
    }
}
