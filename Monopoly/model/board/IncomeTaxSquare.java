package Monopoly.model.board;

import Monopoly.model.player.Player;

public class IncomeTaxSquare extends MonopolySquare{
  private static final int INCOME_TAX_AMOUNT = 200;
  private String text;
  
  @Override
  public void doAction(Player player) {
    player.subtractBalance(INCOME_TAX_AMOUNT);
    text = player.getName() + " paid income tax of 200$";
  }

  @Override
  public String getNotification(){
    return text;
  }
}
