package Monopoly.RunGame.GameRule;

public class JailSquare extends MonopolySquare {
  private String name;

  public JailSquare(String name) {
    this.name = name;
  }

  @Override
  public void doAction(Player player) {
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
