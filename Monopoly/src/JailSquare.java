package Monopoly.src;

import javax.swing.JOptionPane;

public class JailSquare extends MonopolySquare {
  private String text;
  private int choice;

  public JailSquare() {
  }
  
  @Override
  public void doAction(Player player) {
    if (player.isInJail()) {
      player.increaseJailRollCount();
      // If choose Yes or doesn't have
      if (player.hasGetOutOfJailCard()) {
        choice = JOptionPane.showConfirmDialog(
            null, "Do you want to use your Get Out of Jail Free card ?", "Jail", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
          player.useGetOutOfJailCard();
          text = "          " + player.getName() + " used a Get Out of Jail Free card and got out of jail.          ";
        } else {
          text = "          " + player.getName() + " chose not to use the Get Out of Jail Free card.          ";
        } 
      } 

      if (player.hasGetOutOfJailCard() == false || choice == JOptionPane.NO_OPTION) {
        if (player.hasRolledDouble()) {
          player.releaseFromJail();
          text = "          " + player.getName() + " rolled a double and got out of jail.          ";
        } else 
        if (player.getJailRollCount() == 3) {
          player.subtractBalance(50);
          player.releaseFromJail();
          text = "          " + player.getName() + " is out of jail after 3 turns and paid $50 fine.          ";

        } else
        {
          text = "          " + player.getName() + " has been in jail for " + player.getJailRollCount() + " turn(s).          ";
        }
      }
    } else {
      text = player.getName() + " is just visiting the jail.";
    }
  }

  @Override
  public String getNotification(){
    //System.out.println(text);
    return text;
  }
}
