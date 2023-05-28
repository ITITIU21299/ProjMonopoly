package Monopoly.src;

public class GoToJailSquare extends MonopolySquare   {
  private String text;
  public GoToJailSquare() {
    
  }
  
  @Override
  public void doAction(Player player) {
    player.setInJail(true);
    text = "                          " + player.getName() + " has been sent to jail.                          ";
  }
  public String getNotification(){
    return text;
  }
}
