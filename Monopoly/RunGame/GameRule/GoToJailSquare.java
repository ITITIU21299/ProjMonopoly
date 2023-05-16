package Monopoly.RunGame.GameRule;

public class GoToJailSquare extends MonopolySquare {
  public GoToJailSquare() {
    
  }
  
  @Override
  public String doAction(Player player) {
    player.setPosition(Board.JAIL_POSITION);
    player.setInJail(true);
    System.out.println(player.getName() + " has been sent to jail.");
  }
  public String doNoti(Player player){
    return player.getName() + " paid income tax of 200$";
  }
}
