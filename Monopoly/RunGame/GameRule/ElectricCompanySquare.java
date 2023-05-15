package Monopoly.RunGame.GameRule;

public class ElectricCompanySquare extends PropertySquare {
  private int baseRent;

  public ElectricCompanySquare(String name, int price, int baseRent) {
    super(name, price, Color.UTILITY);
    this.baseRent = baseRent;
    
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
      }
      else {
      System.out.println("Not enough balance to buy Electric Company");
      }
    }
    else if (getOwner() != player) {
      int diceRoll = player.getRollDice();
      int rent = calculateRent(diceRoll);
      player.payRentTo(getOwner(), rent);
      System.out.println(player.getName() + " has paid " + rent + " as rent for landing on Electric Company.");
    }
  }
}
