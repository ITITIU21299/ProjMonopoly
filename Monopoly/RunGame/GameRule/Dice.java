package Monopoly.RunGame.GameRule;

import java.awt.Font;
import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Dice extends JButton {
    static int result1 = 0;
    static int result2 =0;

    public Dice() {
        //this.addActionListener(this);
        this.setFocusable(false);
        this.setContentAreaFilled(false);
        this.setFont(new Font("Comic Sans", Font.BOLD, 30));

        Image image = new ImageIcon("Monopoly/res/dice.png").getImage().getScaledInstance(250, 65, java.awt.Image.SCALE_SMOOTH);
        ImageIcon rollIcon = new ImageIcon(image);
        this.setIcon(rollIcon);
    }

    public static void setResult(int n1, int n2) {
        result1 = n1;
        result2 = n2;
    }

    public int getResult() {
        return result1 + result2;
    }
}
