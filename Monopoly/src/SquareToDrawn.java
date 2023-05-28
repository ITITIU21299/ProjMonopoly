package Monopoly.src;

import java.util.HashMap;

public class SquareToDrawn {
    private int coor;
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
