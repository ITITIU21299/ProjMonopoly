package Monopoly.RunGame.GameRule;

import java.util.List;

import javax.swing.JOptionPane;

public class PropertySquare extends MonopolySquare {
  private Board Board;
  private String name;
  private int price;
  private int rent;
  private Player owner;
  private int x, y;
  private String text;

  public enum Color {
    BROWN,
    LIGHT_BLUE,
    PINK,
    ORANGE,
    RED,
    YELLOW,
    GREEN,
    DARK_BLUE,
    RAIL_ROAD,
    UTILITY
  }
  
  private Color color;

  public PropertySquare(String name, int price, Color color) {
    this.name = name;
    this.price = price;
    this.color = color;
    this.owner = null;
  }

  public int getPrice() {
    return price;
  }

  public int getRent() {
    return rent;
  }

  public Player getOwner() {
    return owner;
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  public void setOwner(Player player) {
    owner = player;
  }
  
  @Override
  public void doAction(Player player) {
    if (getOwner() == null) {
      int choice = JOptionPane.showConfirmDialog(null, "Do you want to buy " + getName()+ " for $" + price + "?", "Buy Property",JOptionPane.YES_NO_OPTION);
      if (choice == JOptionPane.YES_OPTION) {
        if (player.getBalance() >= getPrice()) {
          setOwner(player);
          player.purchaseProperty(this);
          text = player.getName() + " bought the " + getName();
        } else {
          JOptionPane.showMessageDialog(null, "Not enough balance to buy " + getName(), "Insufficient Balance",
          JOptionPane.WARNING_MESSAGE);
          text = player.getName() + " doesn't have enough balance to buy the " + getName();
        }
      }
    }
    else if (owner != player) {
      int rent = getPrice()/5;
      player.setBalance(player.getBalance()-rent);
      owner.setBalance(owner.getBalance()+rent);
      //player.payRentTo(getOwner(), rent);
      JOptionPane.showMessageDialog(null, player.getName() + " has paid $" + rent + " as rent to " + getOwner().getName(),"Rent Payment", JOptionPane.INFORMATION_MESSAGE);
    }
  }

  public String getName() {
    return this.name;
  }

  @Override
  public String getNotification() {
    return text;
  }
}
