package Monopoly.RunGame;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Dice extends JButton implements ActionListener {

    Random random = new Random();
    int result = 0;

    ImageIcon dice1 = new ImageIcon("Monopoly/res/dice1.png");    
    ImageIcon dice2 = new ImageIcon("Monopoly/res/dice2.png");
    ImageIcon dice3 = new ImageIcon("Monopoly/res/dice3.png");
    ImageIcon dice4 = new ImageIcon("Monopoly/res/dice4.png");
    ImageIcon dice5 = new ImageIcon("Monopoly/res/dice5.png");
    ImageIcon dice6 = new ImageIcon("Monopoly/res/dice6.png");


    Image icon1 = dice1.getImage();
    Image resizedicon1 = icon1.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
    ImageIcon diceIcon1 = new ImageIcon(resizedicon1);

    Image icon2 = dice2.getImage();
    Image resizedicon2 = icon2.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
    ImageIcon diceIcon2 = new ImageIcon(resizedicon2);

    Image icon3 = dice3.getImage();
    Image resizedicon3 = icon3.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
    ImageIcon diceIcon3 = new ImageIcon(resizedicon3);

    Image icon4 = dice4.getImage();
    Image resizedicon4 = icon4.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
    ImageIcon diceIcon4 = new ImageIcon(resizedicon4);

    Image icon5 = dice5.getImage();
    Image resizedicon5 = icon5.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
    ImageIcon diceIcon5 = new ImageIcon(resizedicon5);

    Image icon6 = dice6.getImage();
    Image resizedicon6 = icon6.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
    ImageIcon diceIcon6 = new ImageIcon(resizedicon6);

    public Dice() {
        this.setBounds(100, 100, 200, 200);
        this.addActionListener(this);
        this.setText("Roll");
        this.setFocusable(false);

        this.setHorizontalTextPosition(JButton.CENTER);
        this.setVerticalTextPosition(JButton.BOTTOM);
        this.setFont(new Font("Comic Sans", Font.BOLD, 30));


    }

    public void actionPerformed(ActionEvent e) {
        
            result = random.nextInt(6) +1;

            if (result==1) this.setIcon(diceIcon1);
            if (result==2) this.setIcon(diceIcon2);
            if (result==3) this.setIcon(diceIcon3);
            if (result==4) this.setIcon(diceIcon4);
            if (result==5) this.setIcon(diceIcon5);
            if (result==6) this.setIcon(diceIcon6);
        
    }
}
