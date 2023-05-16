package Monopoly.RunGame.GameRule;

public class GoToJailSquare extends MonopolySquare {
  public GoToJailSquare() {
    
  }
  
  @Override
  public void doAction(Player player) {
    player.setPosition(Board.JAIL_POSITION);
    player.setInJail(true);
    System.out.println(player.getName() + " has been sent to jail.");
  }
}
