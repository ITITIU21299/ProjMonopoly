package Monopoly.RunGame;

import java.util.List;

public class PropertySquare implements MonopolySquare {
  private Board Board;
  private String name;
  private int price;
  private int rent;
  private Player owner;
  private int x, y;
  private String color;

  public PropertySquare(int price, int rent, Player owner, String name, String color) {
    this.name = name;
    this.price = price;
    this.rent = rent;
    this.owner = owner;
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

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public void setOwner(Player player) {
    owner = player;
  }

  public int getRentWithColorGroup() {
    int numOwned = 0;
    for (MonopolySquare square : Board.getSquare()) {
      if (square instanceof PropertySquare && ((PropertySquare) square).getColor() == getColor()
          && ((PropertySquare) square).getOwner() == owner) {
        numOwned++;
      }
      if (numOwned == 3) {
        return rent * 2;
      } else {
        return rent;
      }
    }
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
    else {
      int rent = getRentWithColorGroup();
      player.payRentTo(player, rent);
    }
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public String getType() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'isOwned'");
  }

  @Override
  public boolean isOwned() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'isOwned'");
  }

  @Override
  public void landOn(Player player) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'landOn'");
  }
}
