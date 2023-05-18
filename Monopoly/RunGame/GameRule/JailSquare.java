package Monopoly.RunGame.GameRule;

import javax.swing.JOptionPane;

public class JailSquare extends MonopolySquare {
  private String text;

  public JailSquare() {

  }
  
  @Override
  public void doAction(Player player) {
    if (player.isInJail()) {
      if (player.hasGetOutOfJailCard()) {
        int choice = JOptionPane.showConfirmDialog(
            null, "Do you want to use your Get Out of Jail Free card?", "Jail", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
          player.useGetOutOfJailCard();
          text = player.getName() + " used a Get Out of Jail Free card and got out of jail.";
        } else {
          text = player.getName() + " chose not to use the Get Out of Jail Free card.";
        }
      } else if (player.hasRolledDouble()) {
        player.releaseFromJail();
        text = player.getName() + " rolled doubles and got out of jail.";
      } else {
        text = player.getName() + " is in jail.";
      }
    } else {
      text = player.getName() + " is just visiting the jail.";
    }
  }

  @Override
  public String getNotification(){
    return text;
  }
}
