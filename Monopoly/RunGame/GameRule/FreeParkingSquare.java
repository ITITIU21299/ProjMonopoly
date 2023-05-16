package Monopoly.RunGame.GameRule;

public class FreeParkingSquare extends MonopolySquare {
  public FreeParkingSquare() {
      
  }

  @Override
  public void doAction(Player player) {
    System.out.println(player.getName() + " landed on Free Parking.");
  }
}
