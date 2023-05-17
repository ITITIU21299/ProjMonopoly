package Monopoly.RunGame.GameRule;

public class ElectricCompanySquare extends PropertySquare {
  private String text;
  public ElectricCompanySquare(String name, int price) {
    super(name, price, Color.UTILITY);
  }

  public int calculateRent(int diceRoll) {
    int rent;
    if (getOwner().ownsMonopolyInColorGroup(getColor())) {
      rent = diceRoll * 10;
    } else {
      rent = diceRoll * 4;
    }
    return rent;
  }
  
  @Override
  public void doAction(Player player) {
    if (getOwner() == null) {
      if (player.getBalance() >= getPrice()) {
        player.purchaseProperty(this);
      } else {
        text = "Not enough balance to buy Electric Company";
      }
    } else if (getOwner() != player) {
      int diceRoll = player.getRollDice();
      int rent = calculateRent(diceRoll);
      player.payRentTo(getOwner(), rent);
      text = player.getName() + " has paid " + rent + " as rent for landing on Electric Company.";
    }
  }
  
  @Override
  public String getNotification() {
    return text;
  }
}
