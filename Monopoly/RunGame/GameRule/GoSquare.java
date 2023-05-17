package Monopoly.RunGame.GameRule;

public class GoSquare extends MonopolySquare {
  public static final int GO_SQUARE_REWARD = 200;
  private String text;
  @Override
  public void doAction(Player player) {
    player.addBalance(GO_SQUARE_REWARD);
    text = player.getName() + " landed on GO.";
  }
  /*public String doNoti(Player player){
    return player.getName() + " paid income tax of 200$";
  }*/
  public String getNotification(){
    return text;
  }
}
