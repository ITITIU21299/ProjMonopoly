package Monopoly.src;

import java.awt.Font;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayerMoney extends JPanel {
    private Player player;
    private JLabel moneyLabel;
    private ImageIcon token;
    public PlayerMoney(Player player, ImageIcon imageIcon){
        this.player = player;
        moneyLabel = new JLabel(player.getName()+ "'s money is $"+player.getBalance());

        token = imageIcon;
        Image image = token.getImage().getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH);
        Icon icon = new ImageIcon(image);

        moneyLabel.setIcon(icon);
        moneyLabel.setForeground(player.getColor());

        Font labelFont = new Font("Arial", Font.BOLD, 22);
        moneyLabel.setFont(labelFont);

        add(moneyLabel);
    }
    public void updateMoney(){
        moneyLabel.setText(player.getName()+ "'s money is $"+player.getBalance());
    }
}
