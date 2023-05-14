package Monopoly.RunGame;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Dice extends JButton implements ActionListener {

    Random random = new Random();
    int result1 = 0;
    int result2 =0;
    ImageIcon[] dice = new ImageIcon[10];
    Image[] icon = new Image[10];
    Image[] resizedicon = new Image[10];
    Icon[] dIcon = new Icon[10];
    //dIcon[5] = new ImageIcon ("Monopoly/res/dice1.png");





    public Dice() {
        this.setBounds(100, 100, 200, 200);
        this.addActionListener(this);
        this.setText("Roll");
        this.setFocusable(false);

        this.setHorizontalTextPosition(JButton.CENTER);
        this.setVerticalTextPosition(JButton.BOTTOM);
        this.setFont(new Font("Comic Sans", Font.BOLD, 30));

        dice[1] = new ImageIcon("Monopoly/res/dice1.png");    
        dice[2] = new ImageIcon("Monopoly/res/dice2.png");
        dice[3] = new ImageIcon("Monopoly/res/dice3.png");
        dice[4] = new ImageIcon("Monopoly/res/dice4.png");
        dice[5] = new ImageIcon("Monopoly/res/dice5.png");
        dice[6] = new ImageIcon("Monopoly/res/dice6.png");

        for (int i=1;i<=6;i++) {
            icon[i] = dice[i].getImage();
            resizedicon[i] = icon[i].getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
            dIcon[i] = new ImageIcon(resizedicon[i]);
        }

    }

    public void actionPerformed(ActionEvent e) {
        
            result1 = random.nextInt(6) +1;
            result2 = random.nextInt(6) +1;


            this.setIcon(new TwoIcon(dIcon[result1], dIcon[result2]));
            
    }
}
