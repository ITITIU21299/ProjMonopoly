package Monopoly.RunGame;

import java.util.HashMap;

import Monopoly.RunGame.GameRule.Player;

public class SquareToDrawn {
    private int coor;
    //Player[] players = new Player[50];
     int noPlayer = 0;

    HashMap <Integer, Player> playersMap = new HashMap<Integer, Player>();
    
    public SquareToDrawn() {
    }
    public void addPlayer (Player player) {
        playersMap.put(player.getIndex(), player);
        this.coor = player.getPosition();
        noPlayer++;
    }
    public void removePlayer (Player player) {
        playersMap.remove(player.getIndex(), player);
        this.coor = -1;
        noPlayer--;
    }
    public Player getPlayer (int index) {
        return playersMap.get(index);
    }
    public int getNoPlayer () {
        return noPlayer;
    }
    public int getCoor() {
        return coor;
    }
    public HashMap <Integer, Player> getMap () {
        return playersMap;
    }
}
