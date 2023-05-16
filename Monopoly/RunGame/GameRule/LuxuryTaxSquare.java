package Monopoly.RunGame.GameRule;

public class LuxuryTaxSquare extends MonopolySquare {
  private static final int LUXURY_TAX_AMOUNT = 75;

  public LuxuryTaxSquare() {
    
  }

  @Override
  public String doAction(Player player) {
    player.subtractBalance(LUXURY_TAX_AMOUNT);
    System.out.println(player.getName() + " paid luxury tax of 75$");
  }
}
