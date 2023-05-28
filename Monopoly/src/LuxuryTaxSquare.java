package Monopoly.src;

public class LuxuryTaxSquare extends MonopolySquare {
  private static final int LUXURY_TAX_AMOUNT = 75;
  private String text;
  public LuxuryTaxSquare() {
    
  }

  @Override
  public void doAction(Player player) {
    player.subtractBalance(LUXURY_TAX_AMOUNT);
    text ="                            "+ player.getName() + " paid luxury tax of 75$                     ";
  }
  public String getNotification(){
    return text;
  }
}
