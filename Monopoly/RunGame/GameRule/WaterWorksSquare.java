package Monopoly.RunGame.GameRule;

import Monopoly.RunGame.Dice;
import Monopoly.RunGame.GameRule.PropertySquare.Color;

public class WaterWorksSquare extends PropertySquare {
  private String text;
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
      text = "Not enough balance to buy Water Works";
      }
    }
    else if (getOwner() != player) {
      Dice dice = new Dice();
      int diceRoll = player.getRollDice();
      int rent = calculateRent(diceRoll);
      player.payRentTo(getOwner(), rent);
      text = player.getName() + " has paid " + rent + " as rent for landing on Water Works.";
    }
    else {
      text = player.getName() + " landed on " + "Water Works".
    }
  }
  
  @Override
  public String getNotification() {
    return text;
  }
}
