/**
 *  Quiz #1
 *  This program creates arrays of baseball player statistics, prints out a roster of the players, and outputs the
 *  at-bats, hits, and batting average of a randomly selected player.
 *  CS160-1001
 *  5/26/24
 *  @author  Jacob Archer
  */

public class BaseballStats {
    public static void main(String[] args) {
        // create arrays of player names, at-bats, and hits
        String[] playerNames = {"Babe Ruth", "Willie Mays", "Barry Bonds", "Ted Williams", "Hank Aaron"};
        int[] atBats = {8399, 10881, 9847, 7706, 12364};
        int[] hits = {2873, 3283, 2935, 2654, 3771};

        // print out the roster of players
        System.out.println("1 " + playerNames[0]);
        System.out.println("2 " + playerNames[1]);
        System.out.println("3 " + playerNames[2]);
        System.out.println("4 " + playerNames[3]);
        System.out.println("5 " + playerNames[4]);

        // randomly select a player
        int randIndex = (int)(Math.random() * playerNames.length);
        String randName = playerNames[randIndex];
        int randBats = atBats[randIndex];
        int randHits = hits[randIndex];

        // calculate the batting average
        double battingAverage = (double)randHits / randBats;

        // output the player's at-bats, hits, and batting average in the format: "Barry Bonds AB: 9847 H: 2935 Ave: 0.298"
        System.out.println(randName + " AB: " + randBats + " H: " + randHits + " Ave: " + battingAverage);
    }
}