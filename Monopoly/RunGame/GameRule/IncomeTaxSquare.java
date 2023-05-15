package Monopoly.RunGame.GameRule;

public class IncomeTaxSquare extends MonopolySquare{
  private static final int INCOME_TAX_AMOUNT = 200;

  @Override
  public void doAction(Player player) {
    player.subtractBalance(INCOME_TAX_AMOUNT);
    System.out.println(player.getName() + " paid income tax of 200$");
  }
}
