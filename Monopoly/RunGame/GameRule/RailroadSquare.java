package Monopoly.RunGame.GameRule;

import java.lang.reflect.Constructor;

public class RailroadSquare extends PropertySquare{
  private static final int BASE_RENT = 25;

  public RailroadSquare(String name) {
    super(name, 200, Color.RAIL_ROAD);
  }

  public int calculateRent() {
    int railRoadOwned = getOwner().getRailroadCount();
    return BASE_RENT * (int) Math.pow(2, railRoadOwned - 1);
  }
}
