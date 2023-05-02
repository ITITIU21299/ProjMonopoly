public class PropertySquare extends MonopolySquare {
  private int price;
  private int rent;
  private Player owner;

  public PropertySquare(int price, int rent, Player owner) {
    super(name);
    this.price = price;
    this.rent = rent;
    this.owner = owner;
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

  public void setOwner(Player Player) {
    owner = player;
  }

  public int getRentWithColorGroup() {
    int numOwned = 0;
    for (MonopolySquare square : Board.getSquare()) {
      if (square instanceof PropertySquare && ((PropertySquare) square).getColor() == getColor()
          && ((PropertySquare) square).getOwner() == owener) {
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
      //Can buy house
    }
    else if (owner == player) {
      //Player already owns the property
    }
    else {
      int rent = getRentWithColorGroup();
      player.payRentTo(player, rent);
    }
  }
}
