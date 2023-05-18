package Monopoly.RunGame;

import Monopoly.RunGame.GameRule.Player;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayerMoney extends JPanel {
    private Player player;
    private JLabel moneyLabel;
    public PlayerMoney(Player player){
        this.player = player;
        moneyLabel = new JLabel(player.getName()+ "'s money is $"+player.getBalance());
        add(moneyLabel);
    }
    public void updateMoney(){
        moneyLabel.setText(player.getName()+ "'s money is $"+player.getBalance());
    }
}
