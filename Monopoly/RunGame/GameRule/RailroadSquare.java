package Monopoly.RunGame.GameRule;

import java.lang.reflect.Constructor;

public class RailroadSquare extends PropertySquare {
  private static final int BASE_RENT = 25;
  private String text;
  private String name;
  private int rent;

  public RailroadSquare(String name) {
    super(name, 200, Color.RAIL_ROAD);
  }

  public int calculateRent() {
    int railRoadOwned = getOwner().getRailroadCount();
    return BASE_RENT * (int) Math.pow(2, railRoadOwned - 1);
  }

   @Override
   public void doAction(Player player) {
      if (getOwner() == null) {
        if (player.getBalance() >= getPrice()) {
          player.purchaseProperty(this);
        } else {
          text = "Not enough balance to buy " + getName();
        }
      } else if (getOwner() != player) {
        int rent = calculateRent();
        player.payRentTo(getOwner(), rent);
        text = player.getName() + " has paid " + rent + " as rent for landing on " + getName();
      } else {
        text = player.getName() + " stands on their own property, " + getName();
      }
     text = player.getName() + " laned on " + getName();
   }
  
  @Override
  public String getNotification() {
    return text;
  }
}
