package Monopoly.RunGame.GameRule;

import Monopoly.RunGame.GameRule.PropertySquare.Color;

public class WaterWorksSquare extends PropertySquare {
  public WaterWorksSquare(String name, int price) {
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
      }
      else {
      System.out.println("Not enough balance to buy Water Works");
      }
    }
    else if (getOwner() != player) {
      int diceRoll = player.getRollDice();
      int rent = calculateRent(diceRoll);
      player.payRentTo(getOwner(), rent);
      System.out.println(player.getName() + " has paid " + rent + " as rent for landing on Water Works.");
    }
  }
}
