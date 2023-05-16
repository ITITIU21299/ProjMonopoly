package Monopoly.RunGame.GameRule;

public class GoSquare extends MonopolySquare {
  public static final int GO_SQUARE_REWARD = 200;

  @Override
  public String doAction(Player player) {
    player.addBalance(GO_SQUARE_REWARD);
    
  }
  public String doNoti(Player player){
    return player.getName() + " paid income tax of 200$";
  }
}
