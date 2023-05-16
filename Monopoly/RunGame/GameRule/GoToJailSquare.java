package Monopoly.RunGame.GameRule;

public class GoToJailSquare extends MonopolySquare {
  private int goToJailPosition;
  private String name;

  public GoToJailSquare(String name, int goToJailPosition) {
    this.name = name;
    this.goToJailPosition = goToJailPosition;
  }
  
  @Override
  public void doAction(Player player) {
    player.setPosition(Board.JAIL_POSITION);
    player.setInJail(true);
    System.out.println(player.getName() + " has been sent to jail.");
  }
}
