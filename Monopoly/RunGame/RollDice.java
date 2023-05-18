package Monopoly.RunGame;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;

//import Monopoly.RunGame.GameRule.Dice;

public class RollDice implements ActionListener {

    Dice dice = new Dice();
    DiceLabel label = new DiceLabel();
    int result1=0;
    int result2=0;
    Random random = new Random();
    ImageIcon[] image = new ImageIcon[10];
    Image[] icon = new Image[10];
    Icon[] dIcon = new Icon[10];
    
    public RollDice(Dice dice, DiceLabel label) {
        this.dice = dice;
        this.label = label;
        dice.addActionListener(this);
        
        image[1] = new ImageIcon("Monopoly/res/dice1.png");    
        image[2] = new ImageIcon("Monopoly/res/dice2.png");
        image[3] = new ImageIcon("Monopoly/res/dice3.png");
        image[4] = new ImageIcon("Monopoly/res/dice4.png");
        image[5] = new ImageIcon("Monopoly/res/dice5.png");
        image[6] = new ImageIcon("Monopoly/res/dice6.png");

        for (int i=1;i<=6;i++) {
            icon[i] = image[i].getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
            dIcon[i] = new ImageIcon(icon[i]);
        }

    }
    public void rollDice (Dice dice, DiceLabel label, Icon x, Icon y) {
        Dice.setResult(1, 2);
        label.setIcon(new TwoIcon(x, y));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        result1 = random.nextInt(6) +1;
        result2 = random.nextInt(6) +1;
        rollDice(dice, label, dIcon[result1], dIcon[result2]);
    }
}
