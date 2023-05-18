package Monopoly.RunGame;

import Monopoly.RunGame.GameRule.Player;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayerMoney extends JPanel {
    private Player player;
    private JLabel moneyLabel;
    public PlayerMoney(Player player){
        this.player = player;
        moneyLabel = new JLabel(player.getName()+ "'s money is $"+player.getBalance());
        Font labelFont = new Font("Arial", Font.BOLD, 16);
        moneyLabel.setFont(labelFont);

        add(moneyLabel);
    }
    public void updateMoney(){
        moneyLabel.setText(player.getName()+ "'s money is $"+player.getBalance());
    }
}
