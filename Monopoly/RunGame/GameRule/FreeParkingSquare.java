package Monopoly.RunGame.GameRule;

public class FreeParkingSquare extends MonopolySquare {
  private String text;
  public FreeParkingSquare() {
      
  }

  @Override
  public void doAction(Player player) {
    text = player.getName() + " landed on Free Parking.";
  }
  public String getNotification(){
    return text;
  }
}
