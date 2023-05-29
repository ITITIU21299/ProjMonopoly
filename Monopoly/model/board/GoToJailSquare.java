package Monopoly.model.board;

import Monopoly.model.player.Player;

public class GoToJailSquare extends MonopolySquare   {
  private String text;
  public GoToJailSquare() {
    
  }
  
  @Override
  public void doAction(Player player) {
    player.setInJail(true);
    text = "                          " + player.getName() + " has been sent to jail.                          ";
  }
  public String getNotification(){
    return text;
  }
}
