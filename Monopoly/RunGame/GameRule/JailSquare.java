package Monopoly.RunGame.GameRule;

public class JailSquare extends MonopolySquare {
  public JailSquare() {
    
  }

  @Override
  public String doAction(Player player) {
    if (player.isInJail()) {
      System.out.println(player.getName() + " is just visiting the jail.");
    }
    else {
      player.setInJail(true);
      player.setPosition(Board.JAIL_POSITION);
      System.out.println(player.getName() + " is sent to jail.");
    }
  }
}
