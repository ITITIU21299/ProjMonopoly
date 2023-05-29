package Monopoly.model.board;

import Monopoly.model.player.Player;

public abstract class MonopolySquare {

  public abstract void doAction(Player player);
  
  public abstract String getNotification();
}
