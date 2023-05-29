package Monopoly.model.board;

import Monopoly.model.player.Player;

public class GoSquare extends MonopolySquare {
  public static final int GO_SQUARE_REWARD = 200;
  private String text;
  @Override
  public void doAction(Player player) {
    player.addBalance(GO_SQUARE_REWARD);
    text = "                             " + player.getName() + " landed on GO.                              ";
  }
  public String getNotification(){
    return text;
  }
}
