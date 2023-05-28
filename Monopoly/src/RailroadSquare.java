package Monopoly.src;


import javax.swing.JOptionPane;

public class RailroadSquare extends PropertySquare {
  private static final int BASE_RENT = 25;
  private String text;

  public RailroadSquare(String name) {
    super(name, 200, Color.RAIL_ROAD);
  }

  public int calculateRent() {
    int railRoadOwned = getOwner().getRailroadCount();
    return BASE_RENT * (int) Math.pow(2, railRoadOwned - 1);
  }
  
@Override
  public void doAction(Player player) {
    if (getOwner()!= null){
      if (getOwner().getIsBankrupted()){
        setOwner(null);
      }}
    if (getOwner() == null) {
    int choice = JOptionPane.showConfirmDialog(null, "Do you want to buy " + getName() + "?", "Buy Property", JOptionPane.YES_NO_OPTION);
      if (choice == JOptionPane.YES_OPTION) {
        if (player.getBalance() >= getPrice()) {
          player.purchaseProperty(this);
          text = player.getName() + " bought the " + getName();
        } else {
          JOptionPane.showMessageDialog(null, "Not enough balance to buy " + getName());
          text = player.getName() + " doesn't have enough balance to buy the " + getName();
         }
      }
    } else if (getOwner() != player) {
        int rent = calculateRent();
        player.payRentTo(getOwner(), rent);
        JOptionPane.showMessageDialog(null,
            player.getName() + " has paid " + rent + " as rent for landing on " + getName());
        text = player.getName() + " has paid $" + rent + " as rent to " + getOwner().getName();
        } else {
          text = player.getName() + " stands on their own property, " + getName();
        }
    text = player.getName() + " landed on " + getName();
  } 
  
  @Override
  public String getNotification() {
    return text;
  }
}
