package Monopoly.RunGame.GameRule;

public class GoSquare extends MonopolySquare {
  public static final int GO_SQUARE_REWARD = 200;

  @Override
  public void doAction(Player player) {
    player.addBalance(GO_SQUARE_REWARD);
    
  }
}
