package Monopoly.src;

public class GoToJailSquare extends MonopolySquare   {
  private String text;
  public GoToJailSquare() {
    
  }
  
  @Override
  public void doAction(Player player) {
    //player.setPosition(Board.JAIL_POSITION);
    player.setInJail(true);
    text = "        " + player.getName() + " has been sent to jail.          ";
  }
  /*public String doNoti(Player player){
    return player.getName() + " paid income tax of 200$";
  }*/
  public String getNotification(){
    return text;
  }
}
