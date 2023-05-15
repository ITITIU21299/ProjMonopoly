package Monopoly.RunGame.GameRule;

import java.util.List;

public class PropertySquare extends MonopolySquare {
  private Board Board;
  private String name;
  private int price;
  private int rent;
  private Player owner;
  private int x, y;

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
  
  public void doAction(Player player) {
    if (owner == null) {
      if (player.getBalance() >= price) {
        player.purchaseProperty(this);
        setOwner(player);
      }
      else {
        System.out.println("Don't have enough balance to buy");
      }
    }
    else if (owner == player) {
      //Player already owns the property, nothing happen
    }
  }

  public String getName() {
    return this.name;
  }
}
