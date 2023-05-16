package Monopoly.RunGame.GameRule;
import Monopoly.RunGame.Notification;

public class IncomeTaxSquare extends MonopolySquare{
  private static final int INCOME_TAX_AMOUNT = 200;
  
  @Override
  public String doAction(Player player) {
    player.subtractBalance(INCOME_TAX_AMOUNT);
    return player.getName() + " paid income tax of 200$";
    //System.out.println(player.getName() + " paid income tax of 200$");
  }
}
