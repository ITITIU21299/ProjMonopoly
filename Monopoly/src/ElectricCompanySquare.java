package Monopoly.src;

import javax.swing.JOptionPane;

public class ElectricCompanySquare extends PropertySquare {
  private String text;
  private int price;

  public ElectricCompanySquare(String name, int price) {
    super(name, price, Color.UTILITY);
  }

  public int getPrice() {
    return price;
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
      int choice = JOptionPane.showConfirmDialog(null, "Do you want to buy the Electric Company?", "Buy Property", JOptionPane.YES_NO_OPTION);
      if (choice == JOptionPane.YES_OPTION) {
        if (player.getBalance() >= getPrice()) {
          player.purchaseProperty(this);
          text = player.getName() + " bought the Electric Company";
        } else {
          JOptionPane.showMessageDialog(null, "Not enough balance to buy the Electric Company");
          text = player.getName() + " doesn't have enough balance to buy the Electric Company";
        }
      }
    } else if (getOwner() != player) {
        int diceRoll = player.getRollDice();
        int rent = calculateRent(diceRoll);
        player.payRentTo(getOwner(), rent);
        JOptionPane.showMessageDialog(null,
        player.getName() + " has paid " + rent + " as rent for landing on Electric Company.");
        text = player.getName() + " has paid " + rent + " as rent for landing on Electric Company.";
    }
  }

  @Override
  public String getNotification() {
    return text;
  }
}
