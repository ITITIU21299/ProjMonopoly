package Monopoly.RunGame;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.html.HTMLDocument.RunElement;

public class Dice extends JButton {

    Random random = new Random();
    static int result1 = 0;
    static int result2 =0;
    ImageIcon[] dice = new ImageIcon[10];
    Image[] icon = new Image[10];
    Image[] resizedicon = new Image[10];
    Icon[] dIcon = new Icon[10];

    public Dice() {
        //this.addActionListener(this);
        this.setFocusable(false);
        this.setContentAreaFilled(false);
        
        this.setFont(new Font("Comic Sans", Font.BOLD, 30));

        Image image = new ImageIcon("Monopoly/res/dice.png").getImage().getScaledInstance(250, 75, java.awt.Image.SCALE_SMOOTH);
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
