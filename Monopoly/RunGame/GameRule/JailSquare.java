package Monopoly.RunGame.GameRule;

public class JailSquare extends MonopolySquare {
  private String text;
  public JailSquare() {
    
  }

  @Override
  public void doAction(Player player) {
    if (player.isInJail() == false) {
      text = player.getName() + " is just visiting the jail.";
    }
    else {
      player.setInJail(true);
      player.setPosition(Board.JAIL_POSITION);
      text = player.getName() + " is sent to jail.";
    }
  }
  public String getNotification(){
    return text;
  }
}
