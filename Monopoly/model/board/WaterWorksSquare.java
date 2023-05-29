package Monopoly.model.board;

import javax.swing.JOptionPane;

import Monopoly.model.player.Player;
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
      if (getOwner()!= null && getOwner().getIsBankrupted()){
        setOwner(null);
      }
      if (getOwner() == null) {
        int choice = JOptionPane.showConfirmDialog(null, "Do you want to buy Water Works?", "Buy Property", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
          if (player.getBalance() >= getPrice()) {
            player.purchaseProperty(this);
            text = player.getName() + " bought the " + getName();
          } else {
            JOptionPane.showMessageDialog(null, "Not enough balance to buy Water Works");
            text = player.getName() + " doesn't have enough balance to buy the " + getName();
          }
        }
      } else if (getOwner() != player) {
          int diceRoll = player.getRollDice();
          int rent = calculateRent(diceRoll);
          player.payRentTo(getOwner(), rent);
          JOptionPane.showMessageDialog(null,
              player.getName() + " has paid $" + rent + " as rent for landing on Water Works.");
          text = player.getName() + " has paid $" + rent + " as rent for landing on Water Works.";
      } else {
        JOptionPane.showMessageDialog(null, player.getName() + " landed on Water Works");
        text = player.getName() + " landed on Water Works";
      }
    }
  
  @Override
  public String getNotification() {
    return text;
  }
}
